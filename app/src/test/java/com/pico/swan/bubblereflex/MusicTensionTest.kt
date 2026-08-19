package com.pico.swan.bubblereflex

import com.pico.swan.bubblereflex.content.MUSIC_TENSION_PROFILES
import com.pico.swan.bubblereflex.content.MUSIC_MELODY_STEPS
import com.pico.swan.bubblereflex.content.MUSIC_RHYTHM_PATTERN
import com.pico.swan.bubblereflex.content.MUSIC_TEMPOS_BPM
import com.pico.swan.bubblereflex.content.synthesizeMusicSample
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class MusicTensionTest {
    @Test
    fun `music tension grows from tutorial through all five tiers`() {
        assertEquals(6, MUSIC_TENSION_PROFILES.size)
        MUSIC_TENSION_PROFILES.zipWithNext().forEach { (current, next) ->
            assertTrue(next.tempoBpm > current.tempoBpm)
            assertTrue(next.padGain > current.padGain)
            assertTrue(next.harmonyGain > current.harmonyGain)
            assertTrue(next.octaveGain > current.octaveGain)
            assertTrue(next.amplitude > current.amplitude)
        }
    }

    @Test
    fun `music profiles keep an audible amplitude floor`() {
        assertTrue(MUSIC_TENSION_PROFILES.minOf { it.amplitude } >= 3_000.0)
    }

    @Test
    fun `music is a paced pentatonic melody instead of a continuous drone`() {
        assertTrue(MUSIC_MELODY_STEPS.size >= 8)
        assertTrue(MUSIC_MELODY_STEPS.distinct().size >= 5)
        assertTrue(MUSIC_MELODY_STEPS.all { it in setOf(0, 2, 4, 7, 9, 12) })
        assertEquals(6, MUSIC_TEMPOS_BPM.size)
        assertTrue(MUSIC_TEMPOS_BPM.zipWithNext().all { (a, b) -> b >= a })
        assertTrue(MUSIC_TEMPOS_BPM.last() <= 108)
        assertTrue(MUSIC_TEMPOS_BPM.first() >= 88)
        assertTrue(MUSIC_TENSION_PROFILES.maxOf { it.padGain } <= 0.04)
        assertTrue(MUSIC_RHYTHM_PATTERN.any { !it })
        assertTrue(MUSIC_RHYTHM_PATTERN.count { it } > MUSIC_RHYTHM_PATTERN.count { !it })
    }

    @Test
    fun `synthesized melody is smooth tonal and unclipped`() {
        val rate = 22_050
        val samples = IntArray(rate) { index ->
            synthesizeMusicSample(index / rate.toDouble(), themeIndex = 0, difficultyTier = 3).toInt()
        }
        val peak = samples.maxOf { kotlin.math.abs(it) }
        var stepSum = 0L
        var zeroCrossings = 0
        for (index in 1 until samples.size) {
            val previous = samples[index - 1]
            val current = samples[index]
            stepSum += kotlin.math.abs(current - previous)
            if ((previous < 0 && current >= 0) || (previous >= 0 && current < 0)) zeroCrossings++
        }
        val averageStep = stepSum.toDouble() / (samples.size - 1)

        assertTrue(peak in 1_000..24_000)
        assertTrue(averageStep < 1_500.0)
        assertTrue(zeroCrossings in 200..2_000)
    }
}
