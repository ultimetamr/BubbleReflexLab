package com.pico.swan.bubblereflex

import com.pico.swan.bubblereflex.domain.*
import org.junit.Assert.*
import org.junit.Test
import kotlin.random.Random

class BubbleGameTest {
    @Test fun `ten thousand generated points are always in the forward safe fan`() {
        val random = Random(1)
        repeat(10_000) { assertTrue(SafeFan.contains(SafeFan.sample(random))) }
    }

    @Test fun `opening introduces all three once then adds calm recap waves`() {
        val game = BubbleGame(seed = 2)
        game.calibrate()
        game.debugAdvance(12f)
        assertEquals(BubbleKind.entries.associateWith { 1 }, game.snapshot().spawnedByKind)
        game.debugAdvance(17.9f)
        val counts = game.snapshot().spawnedByKind
        assertEquals(9, counts.values.sum())
        assertTrue(counts.values.all { it >= 2 })
    }

    @Test fun `pause freezes time and all bubble transforms`() {
        val game = BubbleGame(seed = 3)
        game.calibrate(); game.debugAdvance(3f)
        val before = game.snapshot()
        game.pause(); repeat(100) { game.tick(0.1f) }
        val after = game.snapshot()
        assertEquals(before.elapsedSeconds, after.elapsedSeconds)
        assertEquals(before.bubbles, after.bubbles)
    }

    @Test fun `gray passage untouched is correct and touching is incorrect`() {
        val success = BubbleGame(seed = 4)
        success.calibrate(); success.debugAdvance(34f)
        assertTrue(success.snapshot().stats.gray.correct >= 1)

        val touched = BubbleGame(seed = 4)
        touched.calibrate(); touched.debugAdvance(12f)
        val gray = touched.snapshot().bubbles.first { it.kind == BubbleKind.GRAY }
        touched.interactAt(gray.position, Gesture.TOUCH)
        assertEquals(0, touched.snapshot().stats.gray.correct)
        assertEquals(1, touched.snapshot().stats.gray.total)
    }

    @Test fun `sustained tracking loss pauses after grace and freezes actors`() {
        val game = BubbleGame(seed = 5)
        game.calibrate(); game.debugAdvance(3f)
        game.onTrackingAvailable(false, 1000); game.onTrackingAvailable(false, 1351)
        assertEquals(GamePhase.PAUSED, game.snapshot().phase)
    }

    @Test fun `paused game rejects fallback input`() {
        val game = BubbleGame(seed = 6)
        game.calibrate(); game.debugPopulate(); game.pause()
        val before = game.snapshot()
        assertFalse(game.interactClosest(Gesture.SLAP))
        assertEquals(before.bubbles, game.snapshot().bubbles)
        assertEquals(before.stats, game.snapshot().stats)
    }

    @Test fun `out of bounds bubble is recycled on next tick`() {
        val game = BubbleGame(seed = 7)
        game.calibrate()
        val before = game.snapshot().poolAvailable
        game.debugSpawn(BubbleKind.ORDINARY, Vec3(2.2f, 1.3f, -1.2f))
        assertEquals(before - 1, game.snapshot().poolAvailable)
        game.tick(.05f)
        assertEquals(before, game.snapshot().poolAvailable)
    }

    @Test fun `spawn path converges toward fixed calibrated zone`() {
        val zone = InteractionZone(Vec3(.20f, 1.25f, -.90f))
        val game = BubbleGame(seed = 8)
        game.calibrate(zone); game.debugAdvance(2.1f)
        val first = game.snapshot().bubbles.single().position
        game.debugAdvance(1f)
        val second = game.snapshot().bubbles.single().position
        assertTrue(second.distanceSquared(zone.center) < first.distanceSquared(zone.center))
    }

    @Test fun `opening bubbles use the calm brisk drift speed`() {
        val game = BubbleGame(seed = 12)
        game.calibrate(); game.debugAdvance(1.6f)
        val first = game.snapshot().bubbles.single().position
        game.debugAdvance(1f)
        val second = game.snapshot().bubbles.single().position
        val moved = kotlin.math.sqrt(first.distanceSquared(second))
        assertEquals(BubbleGame.CALM_SPEED, moved, .015f)
    }

    @Test fun `three themes cycle every thirty seconds while five play tiers advance`() {
        val game = BubbleGame(seed = 9)
        game.calibrate()
        assertEquals(3, BubbleGame.THEMES.size)
        assertEquals(0, game.snapshot().segment)
        assertEquals(0, game.snapshot().themeIndex)
        repeat(5) { tier ->
            game.debugAdvance(30.1f)
            assertEquals(tier + 1, game.snapshot().segment)
            val expectedTheme = (tier + 1) % BubbleGame.THEMES.size
            assertEquals(expectedTheme, game.snapshot().themeIndex)
            assertEquals(BubbleGame.THEMES[expectedTheme], game.snapshot().themeLabel)
        }
    }

    @Test fun `input lease prevents simultaneous hand and controller verdicts`() {
        val game = BubbleGame(seed = 10)
        game.calibrate(); game.debugPopulate()
        assertTrue(game.interactClosest(Gesture.SLAP, InputSource.HAND, 1_000L))
        assertFalse(game.interactClosest(Gesture.GRAB, InputSource.CONTROLLER, 1_500L))
        assertTrue(game.interactClosest(Gesture.GRAB, InputSource.CONTROLLER, 2_001L))
        assertEquals(InputSource.CONTROLLER, game.snapshot().activeInput)
    }

    @Test fun `controller ray selects the bubble under the ray`() {
        val game = BubbleGame(seed = 11)
        game.calibrate(); game.debugPopulate()
        assertTrue(game.interactRay(Vec3(0f, 1.38f, 0f), Vec3(0f, 0f, -1f), Gesture.GRAB))
        assertEquals(1, game.snapshot().stats.gold.correct)
    }

    @Test fun `controller grab prioritizes the aimed gold bubble over a nearer blue overlap`() {
        val game = BubbleGame(seed = 22)
        game.calibrate()
        game.debugSpawn(BubbleKind.ORDINARY, Vec3(0f, 1.35f, -.90f))
        game.debugSpawn(BubbleKind.GOLD, Vec3(.12f, 1.35f, -1.20f))

        assertTrue(game.interactRay(Vec3(0f, 1.35f, 0f), Vec3(0f, 0f, -1f), Gesture.GRAB))
        assertEquals(1, game.snapshot().stats.gold.correct)
        assertEquals(0, game.snapshot().stats.ordinary.total)
    }

    @Test fun `two hands can resolve different bubbles while one bubble is judged only once`() {
        val game = BubbleGame(seed = 13)
        game.calibrate(); game.debugPopulate()
        val ordinary = game.snapshot().bubbles.first { it.kind == BubbleKind.ORDINARY }
        val gold = game.snapshot().bubbles.first { it.kind == BubbleKind.GOLD }

        assertTrue(game.interactAt(ordinary.position, Gesture.SLAP, InputSource.HAND, 1_000L))
        assertTrue(game.interactAt(gold.position, Gesture.GRAB, InputSource.HAND, 1_000L))
        assertFalse(game.interactAt(ordinary.position, Gesture.SLAP, InputSource.HAND, 1_000L))

        val stats = game.snapshot().stats
        assertEquals(2, stats.correct)
        assertEquals(2, stats.total)
        assertEquals(1, stats.ordinary.correct)
        assertEquals(1, stats.gold.correct)
    }

    @Test fun `bubble kinds award distinct points and wrong contact deducts`() {
        val game = BubbleGame(seed = 15)
        game.calibrate()
        game.debugSpawn(BubbleKind.ORDINARY, Vec3(-.2f, 1.35f, -1.1f))
        assertTrue(game.interactAt(Vec3(-.2f, 1.35f, -1.1f), Gesture.SLAP))
        assertEquals(100, game.snapshot().stats.score)

        game.debugSpawn(BubbleKind.GOLD, Vec3(.2f, 1.35f, -1.1f))
        assertTrue(game.interactAt(Vec3(.2f, 1.35f, -1.1f), Gesture.GRAB))
        assertEquals(300, game.snapshot().stats.score)

        game.debugSpawn(BubbleKind.GRAY, Vec3(0f, 1.35f, -1.1f))
        assertTrue(game.interactAt(Vec3(0f, 1.35f, -1.1f), Gesture.TOUCH))
        assertEquals(180, game.snapshot().stats.score)
    }

    @Test fun `contact emits a pooled pop feedback above the judged bubble`() {
        val game = BubbleGame(seed = 16)
        val point = Vec3(.12f, 1.42f, -1.05f)
        game.calibrate()
        game.debugSpawn(BubbleKind.GOLD, point)

        assertTrue(game.interactAt(point, Gesture.GRAB))

        val feedback = game.snapshot().scoreFeedback.single()
        assertEquals(BubbleKind.GOLD, feedback.kind)
        assertEquals(200, feedback.points)
        assertEquals(point, feedback.position)
        assertTrue(feedback.popped)
    }

    @Test fun `gold contact may become a successful grab during the contact grace window`() {
        val game = BubbleGame(seed = 20)
        val point = Vec3(0f, 1.35f, -1.0f)
        game.calibrate()
        game.debugSpawn(BubbleKind.GOLD, point)

        assertTrue(game.interactAt(point, Gesture.TOUCH, InputSource.HAND, 1_000L))
        assertEquals(0, game.snapshot().stats.total)
        assertTrue(game.interactAt(point, Gesture.GRAB, InputSource.HAND, 1_060L))
        assertEquals(1, game.snapshot().stats.gold.correct)
        assertEquals(200, game.snapshot().stats.score)
    }

    @Test fun `gold remains available while a real hand finishes closing`() {
        val game = BubbleGame(seed = 23)
        val point = Vec3(0f, 1.35f, -1.0f)
        game.calibrate()
        game.debugSpawn(BubbleKind.GOLD, point)

        assertTrue(game.interactAt(point, Gesture.TOUCH, InputSource.HAND, 1_000L))
        game.debugAdvance(.55f)
        assertEquals(0, game.snapshot().stats.total)
        assertTrue(game.interactAt(point, Gesture.GRAB, InputSource.HAND, 1_550L))
        assertEquals(1, game.snapshot().stats.gold.correct)
    }

    @Test fun `hand grab uses a forgiving gold capture radius`() {
        val game = BubbleGame(seed = 24)
        game.calibrate()
        game.debugSpawn(BubbleKind.GOLD, Vec3(0f, 1.35f, -1.0f))

        assertTrue(game.interactAt(Vec3(.24f, 1.35f, -1.0f), Gesture.GRAB, InputSource.HAND))
        assertEquals(1, game.snapshot().stats.gold.correct)
    }

    @Test fun `gold grab assistance never touches distant ordinary or gray bubbles`() {
        listOf(BubbleKind.ORDINARY, BubbleKind.GRAY).forEach { kind ->
            val game = BubbleGame(seed = 25)
            game.calibrate()
            game.debugSpawn(kind, Vec3(0f, 1.35f, -1.0f))

            assertFalse(game.interactAt(Vec3(.30f, 1.35f, -1.0f), Gesture.GRAB, InputSource.HAND))
            assertEquals(0, game.snapshot().stats.total)
            assertEquals(0, game.snapshot().stats.score)
        }
    }

    @Test fun `real contact beats assisted distant gold target`() {
        val game = BubbleGame(seed = 26)
        game.calibrate()
        game.debugSpawn(BubbleKind.GRAY, Vec3(.04f, 1.35f, -1.0f))
        game.debugSpawn(BubbleKind.GOLD, Vec3(.30f, 1.35f, -1.0f))

        assertTrue(game.interactAt(Vec3(0f, 1.35f, -1.0f), Gesture.GRAB, InputSource.HAND))
        assertEquals(1, game.snapshot().stats.gray.total)
        assertEquals(0, game.snapshot().stats.gray.correct)
    }

    @Test fun `ordinary-only slap arbitration restores blue without touching nearby gold`() {
        val game = BubbleGame(seed = 27)
        game.calibrate()
        game.debugSpawn(BubbleKind.GOLD, Vec3(.08f, 1.35f, -1.0f))
        game.debugSpawn(BubbleKind.ORDINARY, Vec3(0f, 1.35f, -1.0f))

        assertTrue(
            game.interactAt(
                Vec3(0f, 1.35f, -1.0f),
                Gesture.SLAP,
                InputSource.HAND,
                requiredKind = BubbleKind.ORDINARY,
            ),
        )
        assertEquals(1, game.snapshot().stats.ordinary.correct)
        assertEquals(0, game.snapshot().stats.gold.total)
    }

    @Test fun `plain touch still pops a colored bubble after the short grace window`() {
        val game = BubbleGame(seed = 21)
        val point = Vec3(0f, 1.35f, -1.0f)
        game.calibrate()
        game.debugSpawn(BubbleKind.ORDINARY, point)

        assertTrue(game.interactAt(point, Gesture.TOUCH, InputSource.HAND, 1_000L))
        game.tick(.10f)
        game.tick(BubbleGame.CONTACT_GRACE_SECONDS - .11f)
        assertEquals(0, game.snapshot().stats.total)
        game.tick(.02f)
        assertEquals(1, game.snapshot().stats.total)
        assertEquals(-50, game.snapshot().stats.score)
        assertTrue(game.snapshot().scoreFeedback.single().popped)
    }

    @Test fun `safe gray passage awards points while missed colored bubble deducts without pop`() {
        val grayGame = BubbleGame(seed = 17)
        grayGame.calibrate()
        grayGame.debugSpawn(BubbleKind.GRAY, Vec3(0f, 1.35f, -.52f), Vec3(0f, 0f, .20f))
        grayGame.tick(.10f)
        assertEquals(120, grayGame.snapshot().stats.score)
        assertFalse(grayGame.snapshot().scoreFeedback.single().popped)

        val missedGold = BubbleGame(seed = 18)
        missedGold.calibrate()
        missedGold.debugSpawn(BubbleKind.GOLD, Vec3(0f, 1.35f, -.52f), Vec3(0f, 0f, .20f))
        missedGold.tick(.10f)
        assertEquals(-100, missedGold.snapshot().stats.score)
        assertEquals(-100, missedGold.snapshot().scoreFeedback.single().points)
        assertFalse(missedGold.snapshot().scoreFeedback.single().popped)
    }

    @Test fun `score feedback freezes while paused then expires after play resumes`() {
        val game = BubbleGame(seed = 19)
        val point = Vec3(0f, 1.35f, -1.0f)
        game.calibrate()
        game.debugSpawn(BubbleKind.ORDINARY, point)
        game.interactAt(point, Gesture.SLAP)
        game.pause()
        game.tick(2f)
        assertEquals(0f, game.snapshot().scoreFeedback.single().progress)
        game.resume()
        game.debugAdvance(1f)
        assertTrue(game.snapshot().scoreFeedback.isEmpty())
    }

    @Test fun `calibration clamps extreme hand samples into a comfortable fixed band`() {
        val zone = CalibrationPolicy.fromHandSample(Vec3(2f, 2.5f, .2f))
        assertEquals(.28f, zone.center.x)
        assertEquals(1.65f, zone.center.y)
        assertEquals(-.68f, zone.center.z)
    }

    @Test fun `manual end freezes the run and return home clears every bubble`() {
        val game = BubbleGame(seed = 14)
        game.calibrate()
        game.debugAdvance(7f)
        assertTrue(game.snapshot().bubbles.isNotEmpty())

        game.endRun()
        val result = game.snapshot()
        assertEquals(GamePhase.RESULT, result.phase)
        assertTrue(result.bubbles.isEmpty())
        game.tick(10f)
        assertEquals(result.elapsedSeconds, game.snapshot().elapsedSeconds)

        game.returnToStart()
        assertEquals(GamePhase.START, game.snapshot().phase)
        assertTrue(game.snapshot().bubbles.isEmpty())
        game.tick(10f)
        assertTrue(game.snapshot().bubbles.isEmpty())
    }
}
