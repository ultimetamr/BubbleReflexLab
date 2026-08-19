package com.pico.swan.bubblereflex.domain

import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sqrt
import kotlin.math.sin
import kotlin.random.Random

enum class GamePhase { START, TUTORIAL, CALIBRATION, PLAYING, PAUSED, RESULT }
enum class BubbleKind(val label: String) { ORDINARY("普通 · 拍"), GOLD("金色 · 抓"), GRAY("灰色 · 别碰") }
enum class Gesture { SLAP, GRAB, TOUCH }
enum class InputSource(val label: String) { HAND("手势"), CONTROLLER("手柄") }
enum class Badge(val label: String) { NONE("继续练习"), BRONZE("铜徽章"), SILVER("银徽章"), GOLD("金徽章") }

data class Vec3(val x: Float, val y: Float, val z: Float) {
    fun distanceSquared(other: Vec3) = (x-other.x)*(x-other.x)+(y-other.y)*(y-other.y)+(z-other.z)*(z-other.z)
}

data class InteractionZone(
    val center: Vec3 = Vec3(0f, 1.35f, -0.82f),
    val radius: Float = 0.48f,
)

data class BubbleView(val id: Int, val kind: BubbleKind, val position: Vec3, val active: Boolean)
data class ScoreFeedback(
    val slot: Int,
    val kind: BubbleKind,
    val points: Int,
    val position: Vec3,
    val progress: Float,
    val popped: Boolean,
)
data class CategoryScore(val correct: Int = 0, val total: Int = 0)
data class RunStats(
    val correct: Int = 0,
    val total: Int = 0,
    val points: Int = 0,
    val ordinary: CategoryScore = CategoryScore(),
    val gold: CategoryScore = CategoryScore(),
    val gray: CategoryScore = CategoryScore(),
) {
    val accuracy: Int get() = if (total == 0) 0 else (correct * 100f / total).toInt()
    val score: Int get() = points
    val badge: Badge get() = when {
        accuracy >= 90 && total >= 6 -> Badge.GOLD
        accuracy >= 75 && total >= 4 -> Badge.SILVER
        accuracy >= 55 && total >= 3 -> Badge.BRONZE
        else -> Badge.NONE
    }
}

data class GameSnapshot(
    val phase: GamePhase,
    val elapsedSeconds: Float,
    val remainingSeconds: Int,
    val segment: Int,
    val themeIndex: Int,
    val themeLabel: String,
    val prompt: String,
    val bubbles: List<BubbleView>,
    val stats: RunStats,
    val poolAvailable: Int,
    val trackingGraceMs: Long,
    val zone: InteractionZone,
    val activeInput: InputSource?,
    val spawnedByKind: Map<BubbleKind, Int>,
    val scoreFeedback: List<ScoreFeedback>,
)

private data class PooledBubble(
    val id: Int,
    var kind: BubbleKind = BubbleKind.ORDINARY,
    var position: Vec3 = Vec3(0f, 0f, 0f),
    var velocity: Vec3 = Vec3(0f, 0f, 0f),
    var active: Boolean = false,
    var resolved: Boolean = false,
    var pendingTouchAtSeconds: Float? = null,
)

private data class PooledScoreFeedback(
    val slot: Int,
    var kind: BubbleKind = BubbleKind.ORDINARY,
    var points: Int = 0,
    var position: Vec3 = Vec3(0f, 0f, 0f),
    var ageSeconds: Float = 0f,
    var popped: Boolean = false,
    var active: Boolean = false,
)

/** Deep public gameplay seam: timing, safety, pooling and single-verdict adjudication live here. */
class BubbleGame(
    seed: Int = 73,
    private val durationSeconds: Float = 180f,
    poolSize: Int = 24,
) {
    private val random = Random(seed)
    private val pool = List(poolSize) { PooledBubble(it) }
    private val feedbackPool = List(MAX_SCORE_FEEDBACK) { PooledScoreFeedback(it) }
    private var elapsed = 0f
    private var spawnClock = 0f
    private var tutorialSpawnIndex = 0
    private val tierWaveIndexes = IntArray(5)
    private val spawnedByKind = BubbleKind.entries.associateWith { 0 }.toMutableMap()
    private var stats = RunStats()
    private var phase = GamePhase.START
    private var zone = InteractionZone()
    private var trackingLostAt: Long? = null
    private var pausedFrom = GamePhase.PLAYING
    private var activeInput: InputSource? = null
    private var inputLeaseUntilMs = 0L
    private var prompt = "普通泡泡拍破，金色泡泡抓住，灰色泡泡不要触碰"

    fun showTutorial() { phase = GamePhase.TUTORIAL; prompt = "只记三条：拍普通、抓金色、别碰灰色" }
    fun requestCalibration() { phase = GamePhase.CALIBRATION; prompt = "把互动区放在前方自然伸手位置" }

    fun calibrate(interactionZone: InteractionZone = InteractionZone()) {
        zone = interactionZone
        elapsed = 0f
        spawnClock = 0f
        tutorialSpawnIndex = 0
        tierWaveIndexes.fill(0)
        spawnedByKind.keys.forEach { spawnedByKind[it] = 0 }
        stats = RunStats()
        pool.forEach { it.active = false; it.resolved = false; it.pendingTouchAtSeconds = null }
        feedbackPool.forEach { it.active = false }
        phase = GamePhase.PLAYING
        activeInput = null
        inputLeaseUntilMs = 0L
        prompt = "普通泡泡：拍一下"
    }

    fun pause(reason: String = "本局已冻结") {
        if (phase == GamePhase.PLAYING) { pausedFrom = phase; phase = GamePhase.PAUSED; prompt = reason }
    }
    fun resume() { if (phase == GamePhase.PAUSED) { phase = pausedFrom; trackingLostAt = null; prompt = "已继续，所有泡泡保持原位" } }
    fun endRun() { if (phase == GamePhase.PLAYING || phase == GamePhase.PAUSED) finish() }

    fun returnToStart() {
        elapsed = 0f
        spawnClock = 0f
        tutorialSpawnIndex = 0
        tierWaveIndexes.fill(0)
        spawnedByKind.keys.forEach { spawnedByKind[it] = 0 }
        stats = RunStats()
        pool.forEach { it.active = false; it.resolved = false; it.pendingTouchAtSeconds = null }
        feedbackPool.forEach { it.active = false }
        trackingLostAt = null
        activeInput = null
        inputLeaseUntilMs = 0L
        phase = GamePhase.START
        prompt = "普通泡泡拍破，金色泡泡抓住，灰色泡泡不要触碰"
    }

    fun onTrackingAvailable(available: Boolean, nowMs: Long) {
        if (available) { trackingLostAt = null; return }
        if (phase != GamePhase.PLAYING) return
        val started = trackingLostAt ?: nowMs.also { trackingLostAt = it }
        if (nowMs - started >= 350L) pause("手势暂时丢失，泡泡已全部冻结")
    }

    fun tick(deltaSeconds: Float) {
        if (phase != GamePhase.PLAYING || deltaSeconds <= 0f) return
        val dt = deltaSeconds.coerceAtMost(0.1f)
        elapsed += dt
        if (elapsed >= durationSeconds) { finish(); return }
        spawnClock += dt
        feedbackPool.filter { it.active }.forEach {
            it.ageSeconds += dt
            if (it.ageSeconds >= SCORE_FEEDBACK_SECONDS) it.active = false
        }
        spawnIfDue()
        pool.filter { it.active }.forEach { bubble ->
            val pendingTouchAt = bubble.pendingTouchAtSeconds
            if (pendingTouchAt != null && elapsed - pendingTouchAt >= contactGraceSeconds(bubble.kind)) {
                finalizeJudge(bubble, Gesture.TOUCH)
                return@forEach
            }
            bubble.position = Vec3(
                bubble.position.x + bubble.velocity.x * dt,
                bubble.position.y + bubble.velocity.y * dt,
                bubble.position.z + bubble.velocity.z * dt,
            )
            if (bubble.position.z >= zone.center.z + zone.radius * 0.65f) resolvePassage(bubble)
            else if (!MotionBounds.contains(bubble.position, zone)) recycle(bubble)
        }
    }

    fun interactAt(
        point: Vec3,
        gesture: Gesture,
        source: InputSource = InputSource.HAND,
        nowMs: Long = System.currentTimeMillis(),
        requiredKind: BubbleKind? = null,
    ): Boolean {
        if (phase != GamePhase.PLAYING) return false
        val desiredKind = when (gesture) {
            Gesture.GRAB -> BubbleKind.GOLD
            Gesture.SLAP -> BubbleKind.ORDINARY
            Gesture.TOUCH -> null
        }
        val target = pool.asSequence().filter { it.active && !it.resolved && (requiredKind == null || it.kind == requiredKind) }
            .map { it to it.position.distanceSquared(point) }
            .filter { (bubble, distanceSquared) ->
                distanceSquared <= HAND_CONTACT_RADIUS * HAND_CONTACT_RADIUS ||
                    (gesture == Gesture.GRAB && bubble.kind == BubbleKind.GOLD &&
                        distanceSquared <= HAND_GRAB_RADIUS * HAND_GRAB_RADIUS)
            }
            .minWithOrNull(
                compareBy<Pair<PooledBubble, Float>>(
                    // Real contact always wins. The extended grab radius is aim assistance
                    // for gold only and must never create remote contact with another kind.
                    { if (it.second <= HAND_CONTACT_RADIUS * HAND_CONTACT_RADIUS) 0 else 1 },
                    { if (desiredKind == null || it.first.kind == desiredKind) 0 else 1 },
                    { it.second },
                ),
            )?.first ?: return false
        if (!acquireInput(source, nowMs)) return false
        return judge(target, gesture)
    }

    fun interactRay(origin: Vec3, direction: Vec3, gesture: Gesture, source: InputSource = InputSource.CONTROLLER, nowMs: Long = System.currentTimeMillis()): Boolean {
        if (phase != GamePhase.PLAYING) return false
        val length = sqrt(direction.distanceSquared(Vec3(0f, 0f, 0f))).coerceAtLeast(0.001f)
        val d = Vec3(direction.x / length, direction.y / length, direction.z / length)
        val desiredKind = when (gesture) {
            Gesture.GRAB -> BubbleKind.GOLD
            Gesture.SLAP -> BubbleKind.ORDINARY
            Gesture.TOUCH -> null
        }
        val target = pool.asSequence().filter { it.active && !it.resolved }.mapNotNull { bubble ->
            val offset = Vec3(bubble.position.x-origin.x, bubble.position.y-origin.y, bubble.position.z-origin.z)
            val along = offset.x*d.x + offset.y*d.y + offset.z*d.z
            if (along !in 0f..3f) return@mapNotNull null
            val closest = Vec3(origin.x+d.x*along, origin.y+d.y*along, origin.z+d.z*along)
            val crossDistanceSquared = bubble.position.distanceSquared(closest)
            if (crossDistanceSquared <= 0.22f*0.22f) {
                RayCandidate(bubble, along, crossDistanceSquared)
            } else null
        }.minWithOrNull(
            compareBy<RayCandidate>(
                { if (desiredKind == null || it.bubble.kind == desiredKind) 0 else 1 },
                { it.crossDistanceSquared },
                { it.along },
            ),
        )?.bubble ?: return false
        if (!acquireInput(source, nowMs)) return false
        return judge(target, gesture)
    }

    /** Emulator/UI fallback: chooses the bubble nearest the calibrated band, never bypassing pause. */
    fun interactClosest(gesture: Gesture, source: InputSource = InputSource.CONTROLLER, nowMs: Long = System.currentTimeMillis()): Boolean {
        if (phase != GamePhase.PLAYING) return false
        val target = pool.filter { it.active && !it.resolved }.minByOrNull { kotlin.math.abs(it.position.z - zone.center.z) } ?: return false
        if (!acquireInput(source, nowMs)) return false
        return judge(target, gesture)
    }

    fun debugAdvance(seconds: Float) { repeat((seconds * 20).toInt()) { tick(0.05f) } }
    fun debugPopulate() {
        pool.forEach { it.active = false }
        tutorialSpawnIndex = 3
        BubbleKind.entries.forEachIndexed { index, kind ->
            pool[index].apply {
                this.kind = kind
                position = Vec3((index - 1) * 0.28f, 1.38f, -1.48f - index * 0.05f)
                velocity = Vec3(0f, 0f, 0f)
                active = true
                resolved = false
            }
        }
        prompt = "验收短测：三类泡泡位于前方互动区"
    }
    fun debugFinish() = endRun()

    fun snapshot(): GameSnapshot {
        val currentSegment = segment()
        val currentTheme = currentSegment % THEMES.size
        return GameSnapshot(
            phase = phase,
            elapsedSeconds = elapsed,
            remainingSeconds = (durationSeconds - elapsed).coerceAtLeast(0f).toInt(),
            segment = currentSegment,
            themeIndex = currentTheme,
            themeLabel = THEMES[currentTheme],
            prompt = prompt,
            bubbles = pool.filter { it.active }.map { BubbleView(it.id, it.kind, it.position, true) },
            stats = stats,
            poolAvailable = pool.count { !it.active },
            trackingGraceMs = trackingLostAt?.let { System.currentTimeMillis() - it } ?: 0L,
            zone = zone,
            activeInput = activeInput,
            spawnedByKind = spawnedByKind.toMap(),
            scoreFeedback = feedbackPool.filter { it.active }.map {
                ScoreFeedback(
                    slot = it.slot,
                    kind = it.kind,
                    points = it.points,
                    position = it.position,
                    progress = (it.ageSeconds / SCORE_FEEDBACK_SECONDS).coerceIn(0f, 1f),
                    popped = it.popped,
                )
            },
        )
    }

    private fun spawnIfDue() {
        if (elapsed < 30f) {
            if (tutorialSpawnIndex < INTRO_TIMES.size && elapsed >= INTRO_TIMES[tutorialSpawnIndex]) {
                val wave = INTRO_WAVES[tutorialSpawnIndex]
                spawnWave(wave, speed = CALM_SPEED)
                prompt = INTRO_PROMPTS[tutorialSpawnIndex]
                tutorialSpawnIndex++
            }
            return
        }
        val tier = (segment() - 1).coerceIn(0, 4)
        val recipe = TIER_RECIPES[tier]
        val interval = recipe.intervalSeconds
        if (spawnClock < interval) return
        spawnClock = 0f
        val waveIndex = tierWaveIndexes[tier]++
        spawnWave(recipe.waves[waveIndex % recipe.waves.size], speed = CALM_SPEED)
        prompt = "档位 ${tier + 1}：数量与组合增加，漂移速度保持舒缓"
    }

    private fun spawnWave(kinds: List<BubbleKind>, speed: Float) {
        kinds.forEachIndexed { lane, kind -> spawn(kind, speed, lane, kinds.size) }
    }

    private fun spawn(kind: BubbleKind, speed: Float, lane: Int, laneCount: Int) {
        val bubble = pool.firstOrNull { !it.active } ?: return
        bubble.kind = kind
        bubble.position = SafeFan.sample(random, lane, laneCount)
        val passPoint = Vec3(zone.center.x, zone.center.y, zone.center.z + zone.radius)
        val dx = passPoint.x - bubble.position.x
        val dy = passPoint.y - bubble.position.y
        val dz = passPoint.z - bubble.position.z
        val length = sqrt(dx*dx + dy*dy + dz*dz).coerceAtLeast(0.001f)
        bubble.velocity = Vec3(dx/length*speed, dy/length*speed, dz/length*speed)
        bubble.resolved = false
        bubble.pendingTouchAtSeconds = null
        bubble.active = true
        spawnedByKind[kind] = spawnedByKind.getValue(kind) + 1
    }

    internal fun debugSpawn(kind: BubbleKind, position: Vec3, velocity: Vec3 = Vec3(0f, 0f, 0f)) {
        val bubble = pool.firstOrNull { !it.active } ?: return
        bubble.kind = kind; bubble.position = position; bubble.velocity = velocity; bubble.resolved = false
        bubble.pendingTouchAtSeconds = null; bubble.active = true
    }

    private fun judge(bubble: PooledBubble, gesture: Gesture): Boolean {
        if (bubble.resolved) return false
        if (gesture == Gesture.TOUCH && bubble.kind != BubbleKind.GRAY) {
            if (bubble.pendingTouchAtSeconds == null) bubble.pendingTouchAtSeconds = elapsed
            return true
        }
        return finalizeJudge(bubble, gesture)
    }

    private fun finalizeJudge(bubble: PooledBubble, gesture: Gesture): Boolean {
        if (bubble.resolved) return false
        bubble.pendingTouchAtSeconds = null
        val correct = when (bubble.kind) {
            BubbleKind.ORDINARY -> gesture == Gesture.SLAP
            BubbleKind.GOLD -> gesture == Gesture.GRAB
            BubbleKind.GRAY -> false
        }
        val points = record(bubble.kind, correct)
        emitFeedback(bubble, points, popped = true)
        bubble.resolved = true
        prompt = if (correct) "做对了 · ${bubble.kind.label} · +$points" else when (bubble.kind) {
            BubbleKind.ORDINARY -> "普通泡泡要拍破"
            BubbleKind.GOLD -> "金色泡泡要抓住"
            BubbleKind.GRAY -> "灰色泡泡不要触碰，不需要闪躲"
        }
        recycle(bubble)
        return true
    }

    private fun resolvePassage(bubble: PooledBubble) {
        if (!bubble.resolved) {
            val points = record(bubble.kind, bubble.kind == BubbleKind.GRAY)
            emitFeedback(bubble, points, popped = false)
        }
        if (bubble.kind == BubbleKind.GRAY && !bubble.resolved) prompt = "很好：灰色泡泡未触碰"
        recycle(bubble)
    }

    private fun record(kind: BubbleKind, correct: Boolean): Int {
        val points = if (correct) CORRECT_POINTS.getValue(kind) else WRONG_POINTS.getValue(kind)
        fun CategoryScore.add() = copy(correct = this.correct + if (correct) 1 else 0, total = total + 1)
        stats = stats.copy(
            correct = stats.correct + if (correct) 1 else 0,
            total = stats.total + 1,
            points = stats.points + points,
            ordinary = if (kind == BubbleKind.ORDINARY) stats.ordinary.add() else stats.ordinary,
            gold = if (kind == BubbleKind.GOLD) stats.gold.add() else stats.gold,
            gray = if (kind == BubbleKind.GRAY) stats.gray.add() else stats.gray,
        )
        return points
    }

    private fun emitFeedback(bubble: PooledBubble, points: Int, popped: Boolean) {
        val feedback = feedbackPool.firstOrNull { !it.active }
            ?: feedbackPool.maxBy { it.ageSeconds }
        feedback.kind = bubble.kind
        feedback.points = points
        feedback.position = bubble.position
        feedback.ageSeconds = 0f
        feedback.popped = popped
        feedback.active = true
    }

    private fun recycle(bubble: PooledBubble) {
        bubble.active = false
        bubble.resolved = false
        bubble.pendingTouchAtSeconds = null
    }
    private fun finish() {
        pool.filter { it.active }.forEach(::resolvePassage)
        feedbackPool.forEach { it.active = false }
        phase = GamePhase.RESULT
        prompt = "本局完成"
    }
    private fun acquireInput(source: InputSource, nowMs: Long): Boolean {
        if (activeInput != null && activeInput != source && nowMs < inputLeaseUntilMs) return false
        activeInput = source
        inputLeaseUntilMs = nowMs + 900L
        return true
    }

    private fun contactGraceSeconds(kind: BubbleKind): Float = when (kind) {
        BubbleKind.GOLD -> GOLD_CONTACT_GRACE_SECONDS
        BubbleKind.ORDINARY -> CONTACT_GRACE_SECONDS
        BubbleKind.GRAY -> 0f
    }

    private fun segment() = (elapsed / 30f).toInt().coerceIn(0, 5)

    companion object {
        val THEMES = listOf("薄荷晨光", "柔金暮色", "湖蓝微风")
        const val MAX_SCORE_FEEDBACK = 6
        const val SCORE_FEEDBACK_SECONDS = 0.90f
        const val CONTACT_GRACE_SECONDS = 0.14f
        const val GOLD_CONTACT_GRACE_SECONDS = 0.75f
        const val HAND_CONTACT_RADIUS = 0.18f
        const val HAND_GRAB_RADIUS = 0.30f
        val CORRECT_POINTS = mapOf(
            BubbleKind.ORDINARY to 100,
            BubbleKind.GOLD to 200,
            BubbleKind.GRAY to 120,
        )
        val WRONG_POINTS = mapOf(
            BubbleKind.ORDINARY to -50,
            BubbleKind.GOLD to -100,
            BubbleKind.GRAY to -120,
        )
        const val CALM_SPEED = 0.24f
        val INTRO_TIMES = floatArrayOf(1.5f, 6.5f, 11.5f, 16.5f, 21.5f, 26.5f)
        val INTRO_WAVES = listOf(
            listOf(BubbleKind.ORDINARY),
            listOf(BubbleKind.GOLD),
            listOf(BubbleKind.GRAY),
            listOf(BubbleKind.ORDINARY, BubbleKind.GOLD),
            listOf(BubbleKind.ORDINARY, BubbleKind.GRAY),
            listOf(BubbleKind.GOLD, BubbleKind.ORDINARY),
        )
        val INTRO_PROMPTS = listOf(
            "普通泡泡：拍一下",
            "金色泡泡：抓住它",
            "灰色泡泡：保持不碰即可",
            "复习：拍普通，抓金色",
            "复习：拍普通，灰色别碰",
            "复习：抓金色，拍普通",
        )
        val TIER_RECIPES = listOf(
            TierRecipe(4.4f, listOf(listOf(BubbleKind.ORDINARY), listOf(BubbleKind.GOLD), listOf(BubbleKind.ORDINARY, BubbleKind.GOLD), listOf(BubbleKind.GRAY), listOf(BubbleKind.ORDINARY, BubbleKind.ORDINARY))),
            TierRecipe(4.1f, listOf(listOf(BubbleKind.ORDINARY, BubbleKind.GOLD), listOf(BubbleKind.GRAY, BubbleKind.ORDINARY), listOf(BubbleKind.GOLD), listOf(BubbleKind.ORDINARY, BubbleKind.ORDINARY), listOf(BubbleKind.GOLD, BubbleKind.GRAY))),
            TierRecipe(3.8f, listOf(listOf(BubbleKind.ORDINARY, BubbleKind.GRAY), listOf(BubbleKind.GOLD, BubbleKind.ORDINARY), listOf(BubbleKind.GRAY, BubbleKind.ORDINARY), listOf(BubbleKind.GOLD, BubbleKind.GRAY), listOf(BubbleKind.ORDINARY, BubbleKind.GOLD, BubbleKind.ORDINARY))),
            TierRecipe(3.6f, listOf(listOf(BubbleKind.ORDINARY, BubbleKind.GOLD), listOf(BubbleKind.ORDINARY, BubbleKind.GRAY), listOf(BubbleKind.GOLD, BubbleKind.GRAY), listOf(BubbleKind.ORDINARY, BubbleKind.GOLD, BubbleKind.GRAY), listOf(BubbleKind.ORDINARY, BubbleKind.ORDINARY))),
            TierRecipe(3.4f, listOf(listOf(BubbleKind.ORDINARY, BubbleKind.GOLD, BubbleKind.GRAY), listOf(BubbleKind.ORDINARY, BubbleKind.ORDINARY), listOf(BubbleKind.GOLD, BubbleKind.GRAY, BubbleKind.ORDINARY), listOf(BubbleKind.ORDINARY, BubbleKind.GOLD), listOf(BubbleKind.GRAY, BubbleKind.ORDINARY, BubbleKind.GOLD))),
        )
    }
}

private data class RayCandidate(
    val bubble: PooledBubble,
    val along: Float,
    val crossDistanceSquared: Float,
)

data class TierRecipe(val intervalSeconds: Float, val waves: List<List<BubbleKind>>)

object SafeFan {
    fun sample(random: Random, lane: Int = 0, laneCount: Int = 1): Vec3 {
        val spread = if (laneCount <= 1) 0f else (lane - (laneCount - 1) / 2f) * 19f
        val angleDegrees = (spread + (random.nextFloat() * 8f - 4f)).coerceIn(-34f, 34f)
        val angle = angleDegrees * (PI.toFloat() / 180f)
        val distance = 1.75f + random.nextFloat() * 0.35f
        return Vec3(sin(angle) * distance, 1.05f + random.nextFloat() * 0.65f, -cos(angle) * distance)
    }
    fun contains(p: Vec3): Boolean {
        val distance = kotlin.math.sqrt(p.x*p.x + p.z*p.z)
        val angle = kotlin.math.abs(kotlin.math.atan2(p.x, -p.z)) * 180f / PI.toFloat()
        return p.z < -0.45f && p.y in 0.90f..1.90f && distance in 0.45f..2.50f && angle <= 38f
    }
}

object MotionBounds {
    fun contains(p: Vec3, zone: InteractionZone): Boolean =
        p.y in 0.70f..2.10f && kotlin.math.abs(p.x-zone.center.x) <= 1.75f && p.z in -2.70f..(zone.center.z + 0.55f)
}

object CalibrationPolicy {
    /** Captures a comfortable hand sample into a world-fixed band; conservative clamps reject extreme poses. */
    fun fromHandSample(sample: Vec3?): InteractionZone {
        if (sample == null) return InteractionZone()
        return InteractionZone(
            center = Vec3(
                sample.x.coerceIn(-0.28f, 0.28f),
                sample.y.coerceIn(1.05f, 1.65f),
                sample.z.coerceIn(-1.05f, -0.68f),
            ),
        )
    }
}
