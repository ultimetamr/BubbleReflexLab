package com.pico.swan.bubblereflex.content

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pico.spatial.core.ecs.*
import com.pico.spatial.core.ecs.anchor.AnchorTarget
import com.pico.spatial.core.math.Vector3
import com.pico.spatial.tracking.controller.*
import com.pico.spatial.tracking.hand.HandJoint.Index
import com.pico.spatial.tracking.hand.*
import com.pico.spatial.ui.design.*
import com.pico.spatial.ui.foundation.content.SpatialView
import com.pico.swan.bubblereflex.domain.*
import com.pico.swan.bubblereflex.platform.LaunchOptions
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

internal enum class StartFlow { MULTI_STEP, DIRECT }
internal enum class ResultExitBehavior { RETURN_HOME_ONLY, FINISH_ACTIVITY }
internal val NORMAL_START_FLOW = StartFlow.DIRECT
internal val RESULT_EXIT_BEHAVIOR = ResultExitBehavior.FINISH_ACTIVITY
internal const val COMPACT_RULE_TEXT = "蓝色：快速挥手拍  ·  金色：拇指和食指捏合抓住  ·  灰色：不要碰"
internal const val SCORE_RULE_TEXT = "普通正确 +100 / 金色正确 +200 / 灰色未碰 +120；做错会扣分"

@Composable
fun HomeStage() {
    val context = LocalContext.current
    val prefs = remember { context.getSharedPreferences("bubble_reflex", 0) }
    val engine = remember { BubbleGame() }
    var snapshot by remember { mutableStateOf(engine.snapshot()) }
    var panelCollapsed by rememberSaveable { mutableStateOf(false) }
    var showExitConfirmation by rememberSaveable { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        delay(500)
        when (LaunchOptions.captureMode) {
            "tutorial" -> engine.showTutorial()
            "gameplay" -> {
                engine.calibrate()
                engine.debugPopulate()
                panelCollapsed = true
            }
            "feedback" -> {
                engine.calibrate()
                val point = Vec3(0f, 1.38f, -1.20f)
                engine.debugSpawn(BubbleKind.GOLD, point)
                check(engine.interactAt(point, Gesture.GRAB, InputSource.HAND, 1_000L))
                engine.tick(0.25f)
                panelCollapsed = true
                Log.i("BubbleReflex", "FEEDBACK_CAPTURE_READY score=${engine.snapshot().stats.score}")
            }
            "result" -> { engine.calibrate(); engine.debugPopulate(); engine.debugFinish() }
            "acceptance" -> {
                engine.calibrate()
                engine.debugPopulate()
                check(engine.snapshot().bubbles.all { SafeFan.contains(it.position) })
                engine.pause("自动验收：暂停冻结")
                val frozen = engine.snapshot()
                engine.tick(1f)
                check(frozen.elapsedSeconds == engine.snapshot().elapsedSeconds && frozen.bubbles == engine.snapshot().bubbles)
                engine.resume()
                engine.onTrackingAvailable(false, 1_000L)
                engine.onTrackingAvailable(false, 1_351L)
                check(engine.snapshot().phase == GamePhase.PAUSED)
                engine.resume()
                val available = engine.snapshot().poolAvailable
                engine.debugSpawn(BubbleKind.ORDINARY, Vec3(2.2f, 1.3f, -1.2f))
                engine.tick(.05f)
                check(engine.snapshot().poolAvailable == available)
                engine.debugFinish()
                check(engine.snapshot().phase == GamePhase.RESULT)
                Log.i("BubbleReflex", "ACCEPTANCE_PASS frontFan pause trackingGrace oobRecycle result")
            }
        }
        snapshot = engine.snapshot()
    }
    var bestScore by remember { mutableIntStateOf(prefs.getInt("best_score", 0)) }
    val renderer = remember { BubbleSceneRenderer() }
    val music = remember { CalmMusicLayer() }
    val handProvider = remember { HandTrackingProvider() }
    val controllerProvider = remember { ControllerTrackingProvider() }
    val handData by handProvider.dataFlow.collectAsState(HandTrackingData(null, null, 0L))
    val controllerData by controllerProvider.dataFlow.collectAsState(ControllerTrackingData(null, null, 0L))
    val latestHandData by rememberUpdatedState(handData)
    val latestControllerData by rememberUpdatedState(controllerData)
    val panelAnchor = remember { Entity().apply { setName("BubblePanelAnchor") } }
    val scoreAnchor = remember { Entity().apply { setName("ScoreFeedbackAnchor") } }
    val scope = rememberCoroutineScope()
    val latestEngine by rememberUpdatedState(engine)
    val leftHandRuntime = remember { HandGestureRuntime() }
    val rightHandRuntime = remember { HandGestureRuntime() }

    fun refresh() { snapshot = engine.snapshot() }
    fun launchControllerAttempts(
        gate: ControllerPressGate,
        pose: () -> ControllerPose?,
        gesture: Gesture,
    ) = scope.launch {
        do {
            val success = interactFromController(latestEngine, renderer, pose(), gesture)
            gate.onAttemptResult(success)
            snapshot = latestEngine.snapshot()
            if (success) break
            delay(CONTROLLER_RETRY_MS)
        } while (gate.retryIfStillPressed())
    }

    LaunchedEffect(handProvider, controllerProvider) {
        val handStart = handProvider.start()
        val controllerStart = controllerProvider.start()
        delay(500)
        Log.i(
            "BubbleReflex",
            "hand=$handStart/${handProvider.state}/${handProvider.supportState}; " +
                "controller=$controllerStart/${controllerProvider.state}/${controllerProvider.supportState}",
        )
    }
    DisposableEffect(Unit) {
        onDispose {
            handProvider.stop()
            controllerProvider.stop()
            music.release()
            renderer.destroy()
            scoreAnchor.destroy()
            panelAnchor.destroy()
        }
    }

    LaunchedEffect(snapshot.phase, snapshot.themeIndex, snapshot.segment) {
        music.setState(snapshot.phase == GamePhase.PLAYING, snapshot.themeIndex, snapshot.segment)
    }

    LaunchedEffect(snapshot.phase) {
        panelCollapsed = snapshot.phase == GamePhase.PLAYING
    }

    LaunchedEffect(snapshot.phase) {
        if (snapshot.phase != GamePhase.PLAYING) return@LaunchedEffect
        if (LaunchOptions.captureMode == "gameplay" || LaunchOptions.captureMode == "feedback") return@LaunchedEffect
        var last = withFrameNanos { it }
        while (true) {
            val now = withFrameNanos { it }
            if (LaunchOptions.captureMode != "gameplay") {
                val trackingAvailable = latestHandData.left != null || latestHandData.right != null ||
                    latestControllerData.left != null || latestControllerData.right != null
                engine.onTrackingAvailable(trackingAvailable, java.lang.System.currentTimeMillis())
            }
            engine.tick((now-last)/1_000_000_000f); last = now; refresh()
        }
    }

    LaunchedEffect(handData) {
        if (snapshot.phase != GamePhase.PLAYING) return@LaunchedEffect
        val nowMs = java.lang.System.currentTimeMillis()
        val trackingAvailable = handData.left != null || handData.right != null ||
            latestControllerData.left != null || latestControllerData.right != null
        engine.onTrackingAvailable(trackingAvailable, nowMs)
        processHandPose(engine, renderer, handData.left, leftHandRuntime, nowMs)
        processHandPose(engine, renderer, handData.right, rightHandRuntime, nowMs)
        refresh()
    }

    val controllerListener = remember(controllerProvider) {
        val leftPrimaryGate = ControllerPressGate()
        val leftGripGate = ControllerPressGate()
        val rightPrimaryGate = ControllerPressGate()
        val rightGripGate = ControllerPressGate()
        ControllerTrackingProvider.ControllerActionListener { actions ->
            val leftPrimary = actions.left.aButtonPressed || actions.left.xButtonPressed
            val rightPrimary = actions.right.aButtonPressed || actions.right.xButtonPressed
            val leftGrab = controllerGrabPressed(actions.left.gripPressed, actions.left.triggerPressed, actions.left.triggerValue)
            val rightGrab = controllerGrabPressed(actions.right.gripPressed, actions.right.triggerPressed, actions.right.triggerValue)
            if (leftPrimaryGate.shouldAttempt(leftPrimary))
                launchControllerAttempts(leftPrimaryGate, { latestControllerData.left }, Gesture.SLAP)
            if (leftGripGate.shouldAttempt(leftGrab))
                launchControllerAttempts(leftGripGate, { latestControllerData.left }, Gesture.GRAB)
            if (rightPrimaryGate.shouldAttempt(rightPrimary))
                launchControllerAttempts(rightPrimaryGate, { latestControllerData.right }, Gesture.SLAP)
            if (rightGripGate.shouldAttempt(rightGrab))
                launchControllerAttempts(rightGripGate, { latestControllerData.right }, Gesture.GRAB)
        }
    }
    DisposableEffect(controllerProvider, controllerListener) {
        controllerProvider.addControllerActionListener(controllerListener)
        onDispose { controllerProvider.removeControllerActionListener(controllerListener) }
    }

    LaunchedEffect(snapshot.phase, snapshot.stats.score) {
        if (snapshot.phase == GamePhase.RESULT && snapshot.stats.score > bestScore) {
            bestScore = snapshot.stats.score; prefs.edit().putInt("best_score", bestScore).apply()
        }
    }

    SpatialView(
        modifier = Modifier.size(1.dp),
        attachments = {
            AttachmentPanel(id = PANEL_ID) { GamePanel(snapshot, bestScore, panelCollapsed, showExitConfirmation) { event ->
                when (event) {
                UiEvent.START -> when (NORMAL_START_FLOW) {
                    StartFlow.MULTI_STEP -> engine.showTutorial()
                    StartFlow.DIRECT -> {
                        val sample = (latestHandData.right ?: latestHandData.left)
                            ?.get(Index.INDEX_TIP)?.position?.let(renderer::worldToScene)
                        engine.calibrate(CalibrationPolicy.fromHandSample(sample))
                        panelCollapsed = true
                    }
                }
                UiEvent.RECALIBRATE -> engine.requestCalibration()
                UiEvent.CALIBRATE -> {
                    val sample = (latestHandData.right ?: latestHandData.left)
                        ?.get(Index.INDEX_TIP)?.position?.let(renderer::worldToScene)
                    engine.calibrate(CalibrationPolicy.fromHandSample(sample))
                    panelCollapsed = true
                }
                UiEvent.EXPAND_PANEL -> panelCollapsed = false
                UiEvent.COLLAPSE_PANEL -> panelCollapsed = true
                UiEvent.PAUSE -> { engine.pause(); panelCollapsed = false }
                UiEvent.RESUME -> { engine.resume(); panelCollapsed = true }
                UiEvent.END_RUN -> { engine.endRun(); panelCollapsed = false }
                UiEvent.RETURN_HOME -> { engine.returnToStart(); panelCollapsed = false }
                UiEvent.REQUEST_EXIT_APP -> showExitConfirmation = true
                UiEvent.CANCEL_EXIT_APP -> showExitConfirmation = false
                UiEvent.CONFIRM_EXIT_APP -> when (RESULT_EXIT_BEHAVIOR) {
                    ResultExitBehavior.RETURN_HOME_ONLY -> { engine.returnToStart(); panelCollapsed = false }
                    ResultExitBehavior.FINISH_ACTIVITY -> context.findActivity()?.finishAndRemoveTask()
                }
                }; refresh()
            } }
            AttachmentPanel(id = SCORE_PANEL_ID) {
                ScorePopup(snapshot.scoreFeedback.minByOrNull { it.progress })
            }
        },
        initial = { content, attachments ->
            panelAnchor.components.set(
                AnchorComponent(
                    AnchorTarget.createCameraTarget(),
                    AnchorComponent.TrackingMode.ONCE,
                ).apply { positionOffset = PANEL_INITIAL_CAMERA_OFFSET },
            )
            content.addEntity(panelAnchor)
            attachments.entity(PANEL_ID)?.apply {
                components[TransformComponent::class.java]?.setPosition(Vector3.ZERO)
                panelAnchor.addChild(this)
            }
            content.addEntity(scoreAnchor)
            attachments.entity(SCORE_PANEL_ID)?.apply {
                components[TransformComponent::class.java]?.setPosition(Vector3.ZERO)
                scoreAnchor.addChild(this)
            }
        },
        update = { content, attachments ->
            val panelPosition = if (panelCollapsed && snapshot.phase == GamePhase.PLAYING) {
                PANEL_COLLAPSED_LOCAL_POSITION
            } else {
                Vector3.ZERO
            }
            attachments.entity(PANEL_ID)
                ?.components?.get(TransformComponent::class.java)
                ?.setPosition(panelPosition)
            snapshot.scoreFeedback.minByOrNull { it.progress }?.let { feedback ->
                scoreAnchor.components[TransformComponent::class.java]?.apply {
                    setPosition(
                        Vector3(
                            feedback.position.x,
                            feedback.position.y + 0.18f + feedback.progress * 0.08f,
                            feedback.position.z,
                        ),
                    )
                    setScaleVector(Vector3(0.95f, 0.95f, 1f))
                }
            }
            renderer.sync(content, snapshot)
        },
    )
}

private enum class UiEvent {
    START, RECALIBRATE, CALIBRATE, EXPAND_PANEL, COLLAPSE_PANEL,
    PAUSE, RESUME, END_RUN, RETURN_HOME,
    REQUEST_EXIT_APP, CANCEL_EXIT_APP, CONFIRM_EXIT_APP,
}

@Composable
private fun ScorePopup(feedback: ScoreFeedback?) {
    Box(
        modifier = Modifier.width(180.dp).height(88.dp),
        contentAlignment = Alignment.Center,
    ) {
        feedback ?: return@Box
        val positive = feedback.points > 0
        val color = if (!positive) {
            Color(0xFFFF5A67)
        } else when (feedback.kind) {
            BubbleKind.ORDINARY -> Color(0xFF48D9FF)
            BubbleKind.GOLD -> Color(0xFFFFE02E)
            BubbleKind.GRAY -> Color(0xFF8FF0C8)
        }
        Text(
            text = if (positive) "+${feedback.points}" else feedback.points.toString(),
            color = color.copy(alpha = (1f - feedback.progress * 0.72f).coerceIn(0.28f, 1f)),
            fontSize = 38.sp,
            fontWeight = FontWeight.Black,
            modifier = Modifier
                .alpha((1f - feedback.progress * 0.72f).coerceIn(0.28f, 1f))
                .clip(RoundedCornerShape(18.dp))
                .background(Color(0xB0202633))
                .padding(horizontal = 18.dp, vertical = 8.dp),
        )
    }
}

@Composable
private fun GamePanel(
    s: GameSnapshot,
    best: Int,
    collapsed: Boolean,
    showExitConfirmation: Boolean,
    onEvent: (UiEvent) -> Unit,
) {
    Box(
        modifier = Modifier.width(680.dp).height(440.dp),
        contentAlignment = Alignment.BottomEnd,
    ) {
        if (collapsed && s.phase == GamePhase.PLAYING) {
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Column(
                    Modifier.width(520.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color(0xCC202633))
                        .padding(horizontal = 18.dp, vertical = 12.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    Text(s.prompt, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Text(COMPACT_RULE_TEXT, color = Color(0xFFE8EDF7), fontSize = 16.sp)
                }
                Button(
                    onClick = { onEvent(UiEvent.EXPAND_PANEL) },
                    modifier = Modifier.widthIn(min = 180.dp).heightIn(min = 64.dp),
                ) {
                    Text("${s.stats.score}分 · %02d:%02d · 展开/暂停".format(s.remainingSeconds / 60, s.remainingSeconds % 60))
                }
            }
            return@Box
        }

        Column(
            Modifier.fillMaxWidth().clip(RoundedCornerShape(28.dp)).background(PicoTheme.colorScheme.fillPrimary).padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
        ) {
            Text("泡泡反应室", style=PicoTheme.typography.titleLarge, color=PicoTheme.colorScheme.labelPrimaryLight)
            if (showExitConfirmation) {
                Text("确认退出游戏？", style=PicoTheme.typography.titleLarge, color=PicoTheme.colorScheme.labelPrimaryLight)
                Text("退出后将返回系统界面，本局结算已经保存。", color=PicoTheme.colorScheme.labelPrimaryLight)
                Row(horizontalArrangement=Arrangement.spacedBy(12.dp)) {
                    Button(onClick={onEvent(UiEvent.CANCEL_EXIT_APP)}, modifier=Modifier.heightIn(min=64.dp)) { Text("取消") }
                    Button(onClick={onEvent(UiEvent.CONFIRM_EXIT_APP)}, modifier=Modifier.heightIn(min=64.dp)) { Text("确认退出") }
                }
            } else when (s.phase) {
            GamePhase.START -> {
                Text("三种泡泡 · 五级固定难度 · 三套主题", color=PicoTheme.colorScheme.labelPrimaryLight)
                Text("三分钟单局 · 最高分 $best", color=PicoTheme.colorScheme.labelPrimaryLight)
                RuleRow()
                Text(SCORE_RULE_TEXT, color=PicoTheme.colorScheme.labelPrimaryLight)
                Text("点击一次直接开始；首 30 秒逐条练习，提示会固定保留在右下角。", color=PicoTheme.colorScheme.labelPrimaryLight)
                Button(onClick={onEvent(UiEvent.START)}, modifier=Modifier.heightIn(min=64.dp)) { Text("开始游戏") }
            }
            GamePhase.TUTORIAL -> {
                Text("三种泡泡，一眼分辨", style=PicoTheme.typography.titleLarge, color=PicoTheme.colorScheme.labelPrimaryLight)
                RuleRow()
                Text("灰泡通过互动区前不触碰即可；不需要闪躲。", color=PicoTheme.colorScheme.labelPrimaryLight)
                Button(onClick={onEvent(UiEvent.START)}, modifier=Modifier.heightIn(min=64.dp)) { Text("开始游戏") }
            }
            GamePhase.CALIBRATION -> {
                Text("校准互动区", style=PicoTheme.typography.titleLarge, color=PicoTheme.colorScheme.labelPrimaryLight)
                Text("自然坐好或站好，面向前方。互动区固定在胸前自然伸手位置；泡泡只从前方扇形出现。", color=PicoTheme.colorScheme.labelPrimaryLight)
                Button(onClick={onEvent(UiEvent.CALIBRATE)}, modifier=Modifier.heightIn(min=64.dp)) { Text("确认位置并开始") }
            }
            GamePhase.PLAYING -> {
                Row(Modifier.fillMaxWidth(), horizontalArrangement=Arrangement.SpaceBetween) {
                    Text("%02d:%02d".format(s.remainingSeconds/60,s.remainingSeconds%60), style=PicoTheme.typography.titleLarge, color=PicoTheme.colorScheme.labelPrimaryLight)
                    Text("${s.themeLabel} · ${if (s.segment == 0) "慢速引导" else "档位 ${s.segment}/5"}", color=PicoTheme.colorScheme.labelPrimaryLight)
                }
                Text(s.prompt, color=PicoTheme.colorScheme.labelPrimaryLight)
                Text(COMPACT_RULE_TEXT, color=PicoTheme.colorScheme.labelPrimaryLight)
                Text("准确率 ${s.stats.accuracy}% · 对 ${s.stats.correct}/${s.stats.total} · 输入 ${s.activeInput?.label ?: "待命"} · 池空闲 ${s.poolAvailable}", color=PicoTheme.colorScheme.labelPrimaryLight)
                Text("当前得分 ${s.stats.score}（普通 +100 / 金色 +200 / 灰色未碰 +120）", color=PicoTheme.colorScheme.labelPrimaryLight)
                Row(horizontalArrangement=Arrangement.spacedBy(10.dp)) {
                    Button(onClick={onEvent(UiEvent.PAUSE)}, modifier=Modifier.heightIn(min=64.dp)) { Text("暂停") }
                    Button(onClick={onEvent(UiEvent.COLLAPSE_PANEL)}, modifier=Modifier.heightIn(min=64.dp)) { Text("收起到右下角") }
                    Button(onClick={onEvent(UiEvent.END_RUN)}, modifier=Modifier.heightIn(min=64.dp)) { Text("结束本局") }
                }
            }
            GamePhase.PAUSED -> {
                Text("已暂停 · 所有泡泡已冻结", style=PicoTheme.typography.titleLarge, color=PicoTheme.colorScheme.labelPrimaryLight)
                Text(s.prompt, color=PicoTheme.colorScheme.labelPrimaryLight)
                Button(onClick={onEvent(UiEvent.RESUME)}, modifier=Modifier.heightIn(min=64.dp)) { Text("继续本局") }
                Button(onClick={onEvent(UiEvent.RECALIBRATE)}, modifier=Modifier.heightIn(min=64.dp)) { Text("重新校准") }
                Button(onClick={onEvent(UiEvent.END_RUN)}, modifier=Modifier.heightIn(min=64.dp)) { Text("结束本局") }
            }
            GamePhase.RESULT -> {
                Text("本局已结束", style=PicoTheme.typography.titleLarge, color=PicoTheme.colorScheme.labelPrimaryLight)
                Text("${s.stats.badge.label} · 准确率 ${s.stats.accuracy}%", style=PicoTheme.typography.titleLarge, color=PicoTheme.colorScheme.labelPrimaryLight)
                Text("得分 ${s.stats.score} · 最高分 $best", color=PicoTheme.colorScheme.labelPrimaryLight)
                Text("普通 ${s.stats.ordinary.correct}/${s.stats.ordinary.total}   金色 ${s.stats.gold.correct}/${s.stats.gold.total}   灰色 ${s.stats.gray.correct}/${s.stats.gray.total}", color=PicoTheme.colorScheme.labelPrimaryLight)
                Row(horizontalArrangement=Arrangement.spacedBy(10.dp)) {
                    Button(onClick={onEvent(UiEvent.START)}, modifier=Modifier.heightIn(min=64.dp)) { Text("再来一局") }
                    Button(onClick={onEvent(UiEvent.RETURN_HOME)}, modifier=Modifier.heightIn(min=64.dp)) { Text("返回开始") }
                }
                Button(onClick={onEvent(UiEvent.REQUEST_EXIT_APP)}, modifier=Modifier.heightIn(min=64.dp)) { Text("退出游戏") }
            }
        }
        }
    }
}

@Composable private fun RuleRow() {
    Row(Modifier.fillMaxWidth(), horizontalArrangement=Arrangement.spacedBy(10.dp)) {
        listOf(
            "蓝色泡泡\n快速拍一下\n正确 +100",
            "金色泡泡\n拇指食指捏合\n抓住 · +200",
            "灰色泡泡\n完全不要碰\n通过 +120",
        ).forEach { label ->
            Box(Modifier.weight(1f).clip(RoundedCornerShape(18.dp)).background(PicoTheme.colorScheme.fillPrimary).padding(16.dp)) {
                Text(label, color=PicoTheme.colorScheme.labelPrimaryLight)
            }
        }
    }
}

private const val PANEL_ID = "bubble_game_panel"
private const val SCORE_PANEL_ID = "score_feedback"
internal data class PanelPose(val x: Float, val y: Float, val z: Float)
internal val EXPANDED_PANEL_POSE = PanelPose(0.00f, -0.05f, -1.05f)
private val PANEL_INITIAL_CAMERA_OFFSET = Vector3(
    EXPANDED_PANEL_POSE.x,
    EXPANDED_PANEL_POSE.y,
    EXPANDED_PANEL_POSE.z,
)
private val PANEL_COLLAPSED_LOCAL_POSITION = Vector3(0.72f, -0.58f, 0f)

private tailrec fun Context.findActivity(): Activity? = when (this) {
    is Activity -> this
    is ContextWrapper -> baseContext.findActivity()
    else -> null
}

private data class HandGestureRuntime(
    var pinched: Boolean = false,
    var previousTip: Vec3? = null,
    var previousTipTimeMs: Long = 0L,
) {
    fun reset() {
        pinched = false
        previousTip = null
        previousTipTimeMs = 0L
    }
}

private fun processHandPose(
    game: BubbleGame,
    renderer: BubbleSceneRenderer,
    hand: HandPose?,
    runtime: HandGestureRuntime,
    nowMs: Long,
) {
    if (hand == null) {
        runtime.reset()
        return
    }
    val tipWorld = hand[Index.INDEX_TIP].position
    val thumb = hand[Index.THUMB_TIP].position
    val tip = renderer.worldToScene(tipWorld) ?: run {
        runtime.reset()
        return
    }
    val grabPoint = renderer.worldToScene(
        Vector3(
            (tipWorld.x + thumb.x) * .5f,
            (tipWorld.y + thumb.y) * .5f,
            (tipWorld.z + thumb.z) * .5f,
        ),
    ) ?: tip
    val pinchDistance = kotlin.math.sqrt(
        (tipWorld.x - thumb.x) * (tipWorld.x - thumb.x) +
            (tipWorld.y - thumb.y) * (tipWorld.y - thumb.y) +
            (tipWorld.z - thumb.z) * (tipWorld.z - thumb.z),
    )
    val nowPinched = handPinchActive(runtime.pinched, pinchDistance)
    val previous = runtime.previousTip
    val speed = if (previous != null && nowMs > runtime.previousTipTimeMs) {
        kotlin.math.sqrt(tip.distanceSquared(previous)) / ((nowMs - runtime.previousTipTimeMs) / 1000f)
    } else {
        0f
    }
    val ordinarySlapSucceeded = speed > .70f && game.interactAt(
        tip,
        Gesture.SLAP,
        InputSource.HAND,
        nowMs,
        requiredKind = BubbleKind.ORDINARY,
    )
    when {
        ordinarySlapSucceeded -> Unit
        // Keep attempting while the fingers remain pinched. Players commonly close their
        // fingers just before entering the bubble; restricting GRAB to the transition frame
        // made that natural motion look like an incorrect touch.
        nowPinched -> game.interactAt(grabPoint, Gesture.GRAB, InputSource.HAND, nowMs)
        !nowPinched && speed > .70f -> game.interactAt(tip, Gesture.SLAP, InputSource.HAND, nowMs)
        else -> game.interactAt(tip, Gesture.TOUCH, InputSource.HAND, nowMs)
    }
    runtime.pinched = nowPinched
    runtime.previousTip = tip
    runtime.previousTipTimeMs = nowMs
}

internal class ControllerPressGate {
    private var pressed = false
    private var attemptPending = false
    private var consumed = false

    @Synchronized
    fun shouldAttempt(isPressed: Boolean): Boolean {
        if (!isPressed) {
            pressed = false
            attemptPending = false
            consumed = false
            return false
        }
        if (!pressed) pressed = true
        if (attemptPending || consumed) return false
        attemptPending = true
        return true
    }

    @Synchronized
    fun onAttemptResult(success: Boolean) {
        attemptPending = false
        consumed = success
    }

    @Synchronized
    fun retryIfStillPressed(): Boolean {
        if (!pressed || attemptPending || consumed) return false
        attemptPending = true
        return true
    }
}

internal fun controllerGrabPressed(gripPressed: Boolean, triggerPressed: Boolean, triggerValue: Float): Boolean =
    gripPressed || triggerPressed || triggerValue >= 0.55f

internal fun handPinchActive(wasPinched: Boolean, pinchDistanceMeters: Float): Boolean =
    if (wasPinched) pinchDistanceMeters < .085f else pinchDistanceMeters < .065f

private fun interactFromController(
    game: BubbleGame,
    renderer: BubbleSceneRenderer,
    pose: ControllerPose?,
    gesture: Gesture,
): Boolean {
    pose ?: return false
    val forward = pose.rotation.rotateVector(Vector3.BACK)
    val ray = renderer.worldRayToScene(pose.position, forward) ?: return false
    return game.interactRay(ray.first, ray.second, gesture, InputSource.CONTROLLER)
}

private const val CONTROLLER_RETRY_MS = 45L
