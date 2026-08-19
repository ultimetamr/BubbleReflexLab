package com.pico.swan.bubblereflex

import com.pico.swan.bubblereflex.content.shouldShowTutorialBubbles
import com.pico.swan.bubblereflex.content.EXPANDED_PANEL_POSE
import com.pico.swan.bubblereflex.content.NORMAL_START_FLOW
import com.pico.swan.bubblereflex.content.RESULT_EXIT_BEHAVIOR
import com.pico.swan.bubblereflex.content.ResultExitBehavior
import com.pico.swan.bubblereflex.content.StartFlow
import com.pico.swan.bubblereflex.content.ControllerPressGate
import com.pico.swan.bubblereflex.content.controllerGrabPressed
import com.pico.swan.bubblereflex.content.COMPACT_RULE_TEXT
import com.pico.swan.bubblereflex.content.SCORE_RULE_TEXT
import com.pico.swan.bubblereflex.content.handPinchActive
import com.pico.swan.bubblereflex.domain.GamePhase
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PresentationPolicyTest {
    @Test
    fun `start and result never show tutorial bubbles`() {
        assertFalse(shouldShowTutorialBubbles(GamePhase.START))
        assertFalse(shouldShowTutorialBubbles(GamePhase.RESULT))
        assertTrue(shouldShowTutorialBubbles(GamePhase.TUTORIAL))
    }

    @Test
    fun `expanded panel is centered at comfortable eye height`() {
        assertTrue(kotlin.math.abs(EXPANDED_PANEL_POSE.x) < 0.01f)
        assertTrue(EXPANDED_PANEL_POSE.y in -0.12f..0.08f)
        assertTrue(EXPANDED_PANEL_POSE.z in -1.20f..-0.90f)
    }

    @Test
    fun `normal flow starts the run in one click and result can close the app`() {
        assertEquals(StartFlow.DIRECT, NORMAL_START_FLOW)
        assertEquals(ResultExitBehavior.FINISH_ACTIVITY, RESULT_EXIT_BEHAVIOR)
    }

    @Test
    fun `held controller grip retries after an early ray miss`() {
        val gate = ControllerPressGate()
        assertTrue(gate.shouldAttempt(true))
        gate.onAttemptResult(false)
        assertTrue(gate.retryIfStillPressed())
        gate.onAttemptResult(true)
        assertFalse(gate.retryIfStillPressed())
        assertFalse(gate.shouldAttempt(false))
        assertTrue(gate.shouldAttempt(true))
    }

    @Test
    fun `either side grip or index trigger is accepted as controller grab`() {
        assertTrue(controllerGrabPressed(gripPressed = true, triggerPressed = false, triggerValue = 0f))
        assertTrue(controllerGrabPressed(gripPressed = false, triggerPressed = true, triggerValue = 1f))
        assertTrue(controllerGrabPressed(gripPressed = false, triggerPressed = false, triggerValue = .72f))
        assertFalse(controllerGrabPressed(gripPressed = false, triggerPressed = false, triggerValue = .10f))
    }

    @Test
    fun `compact in-game hint names concrete controls and scoring`() {
        assertTrue(COMPACT_RULE_TEXT.contains("拇指和食指捏合"))
        assertTrue(COMPACT_RULE_TEXT.contains("快速挥手拍"))
        assertTrue(COMPACT_RULE_TEXT.contains("灰色：不要碰"))
        assertTrue(SCORE_RULE_TEXT.contains("扣分"))
    }

    @Test
    fun `relaxed sixty millimeter hand pinch starts and remains a grab`() {
        assertTrue(handPinchActive(wasPinched = false, pinchDistanceMeters = .038f))
        assertTrue(handPinchActive(wasPinched = false, pinchDistanceMeters = .060f))
        assertTrue(handPinchActive(wasPinched = true, pinchDistanceMeters = .080f))
        assertFalse(handPinchActive(wasPinched = false, pinchDistanceMeters = .090f))
    }
}
