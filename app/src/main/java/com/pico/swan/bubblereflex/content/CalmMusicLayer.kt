package com.pico.swan.bubblereflex.content

import android.media.AudioAttributes
import android.media.AudioFormat
import android.media.AudioTrack
import android.util.Log
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger
import kotlin.math.PI
import kotlin.math.exp
import kotlin.math.sin

internal data class MusicTensionProfile(
    val tempoBpm: Int,
    val padGain: Double,
    val harmonyGain: Double,
    val octaveGain: Double,
    val amplitude: Double,
)

internal val MUSIC_TENSION_PROFILES = listOf(
    MusicTensionProfile(88, 0.004, 0.020, 0.000, 5_400.0),
    MusicTensionProfile(92, 0.010, 0.034, 0.012, 5_600.0),
    MusicTensionProfile(96, 0.016, 0.048, 0.024, 5_800.0),
    MusicTensionProfile(100, 0.022, 0.062, 0.036, 6_000.0),
    MusicTensionProfile(104, 0.030, 0.078, 0.048, 6_200.0),
    MusicTensionProfile(108, 0.038, 0.094, 0.060, 6_400.0),
)

/** Original four-bar summer pentatonic phrase. Values are semitones above each theme root. */
internal val MUSIC_MELODY_STEPS = listOf(
    0, 4, 7, 9, 7, 4, 2, 0,
    4, 7, 12, 9, 7, 4, 2, 4,
    7, 9, 12, 9, 7, 4, 7, 2,
    4, 2, 0, 2, 4, 7, 4, 0,
)
internal val MUSIC_RHYTHM_PATTERN = listOf(
    true, true, true, false, true, true, false, true,
    true, false, true, true, true, false, true, true,
)
internal val MUSIC_TEMPOS_BPM = MUSIC_TENSION_PROFILES.map { it.tempoBpm }
private val MUSIC_CHORD_ROOT_STEPS = listOf(0, 9, 5, 7)
private val MUSIC_CHORD_THIRD_STEPS = listOf(4, 12, 9, 11)
private val THEME_BASE_FREQUENCIES = doubleArrayOf(329.63, 369.99, 293.66)

internal fun synthesizeMusicSample(t: Double, themeIndex: Int, difficultyTier: Int): Short {
    val base = THEME_BASE_FREQUENCIES[themeIndex.coerceIn(0, 2)]
    val profile = MUSIC_TENSION_PROFILES[difficultyTier.coerceIn(0, 5)]
    val noteSeconds = 30.0 / profile.tempoBpm
    val noteNumber = (t / noteSeconds).toLong()
    val noteTime = t - noteNumber * noteSeconds
    val melodyStep = MUSIC_MELODY_STEPS[(noteNumber % MUSIC_MELODY_STEPS.size).toInt()]
    val melodyFrequency = base * Math.pow(2.0, melodyStep / 12.0)
    val noteIsActive = MUSIC_RHYTHM_PATTERN[(noteNumber % MUSIC_RHYTHM_PATTERN.size).toInt()]
    val gateSeconds = noteSeconds * 0.72
    val attack = (noteTime / 0.008).coerceIn(0.0, 1.0)
    val noteEnvelope = if (noteIsActive && noteTime < gateSeconds) {
        attack * exp(-3.2 * noteTime / gateSeconds)
    } else 0.0
    // A soft toy-piano timbre: a warm fundamental with quickly fading wooden overtones.
    val melody = noteEnvelope * (
        sin(2.0 * PI * melodyFrequency * noteTime) +
            0.13 * exp(-5.0 * noteTime) * sin(2.0 * PI * melodyFrequency * 2.0 * noteTime) +
            0.025 * exp(-8.0 * noteTime) * sin(2.0 * PI * melodyFrequency * 4.0 * noteTime)
        )
    val chordIndex = ((noteNumber / 4) % MUSIC_CHORD_ROOT_STEPS.size).toInt()
    val chordRoot = base * 0.5 * Math.pow(2.0, MUSIC_CHORD_ROOT_STEPS[chordIndex] / 12.0)
    val chordThird = base * 0.5 * Math.pow(2.0, MUSIC_CHORD_THIRD_STEPS[chordIndex] / 12.0)
    val chordFifth = chordRoot * Math.pow(2.0, 7.0 / 12.0)
    val chordTime = t % (noteSeconds * 4.0)
    val chordEnvelope = if (chordTime < noteSeconds * 2.1) {
        exp(-3.2 * chordTime / (noteSeconds * 2.1))
    } else 0.0
    val harmony = profile.harmonyGain * chordEnvelope * (
        0.72 * sin(2.0 * PI * chordRoot * chordTime) +
            0.46 * sin(2.0 * PI * chordThird * chordTime) +
            0.38 * sin(2.0 * PI * chordFifth * chordTime)
        )
    val octave = profile.octaveGain * noteEnvelope *
        sin(2.0 * PI * melodyFrequency * 2.0 * noteTime)
    val sparkleEnvelope = if (noteIsActive && noteTime < noteSeconds * 0.20) {
        exp(-7.0 * noteTime / (noteSeconds * 0.20))
    } else 0.0
    val sparkle = profile.padGain * sparkleEnvelope *
        sin(2.0 * PI * melodyFrequency * 4.0 * noteTime)
    val wave = melody + harmony + octave + sparkle
    return (wave * profile.amplitude).toInt()
        .coerceIn(Short.MIN_VALUE.toInt(), Short.MAX_VALUE.toInt()).toShort()
}

/** Original bright summer-light-music layer: themes change key and tiers add color without pressure. */
class CalmMusicLayer {
    private val playing = AtomicBoolean(false)
    private val enabled = AtomicBoolean(false)
    private val theme = AtomicInteger(0)
    private val difficulty = AtomicInteger(0)
    private var track: AudioTrack? = null
    private var thread: Thread? = null

    fun setState(active: Boolean, themeIndex: Int, difficultyTier: Int) {
        val nextTheme = themeIndex.coerceIn(0, 2)
        val nextDifficulty = difficultyTier.coerceIn(0, 5)
        theme.set(nextTheme)
        difficulty.set(nextDifficulty)
        enabled.set(active)
        val profile = MUSIC_TENSION_PROFILES[nextDifficulty]
        Log.i(
            "BubbleReflexMusic",
            "active=$active theme=$nextTheme tier=$nextDifficulty style=bright_pluck bpm=${profile.tempoBpm}",
        )
        if (active && !playing.get()) start()
        if (active) {
            track?.runCatching { play() }
        } else {
            track?.runCatching { pause(); flush() }
        }
    }

    private fun start() {
        if (!playing.compareAndSet(false, true)) return
        val rate = 22_050
        val buffer = AudioTrack.getMinBufferSize(rate, AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT).coerceAtLeast(2048)
        track = AudioTrack.Builder()
            .setAudioAttributes(AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_GAME).setContentType(AudioAttributes.CONTENT_TYPE_MUSIC).build())
            .setAudioFormat(AudioFormat.Builder().setSampleRate(rate).setChannelMask(AudioFormat.CHANNEL_OUT_MONO).setEncoding(AudioFormat.ENCODING_PCM_16BIT).build())
            .setBufferSizeInBytes(buffer * 2).setTransferMode(AudioTrack.MODE_STREAM).build().also {
                it.setVolume(1.0f)
                it.play()
                Log.i("BubbleReflexMusic", "trackReady state=${it.state} playState=${it.playState} rate=$rate buffer=$buffer")
            }
        thread = Thread({
            val samples = ShortArray(buffer)
            var cursor = 0L
            while (playing.get()) {
                if (!enabled.get()) {
                    Thread.sleep(20)
                    continue
                }
                for (i in samples.indices) {
                    val t = cursor++ / rate.toDouble()
                    samples[i] = synthesizeMusicSample(t, theme.get(), difficulty.get())
                }
                track?.write(samples, 0, samples.size)
            }
        }, "BubbleCalmMusic").apply { isDaemon = true; start() }
    }

    fun release() {
        enabled.set(false); playing.set(false)
        thread?.join(150); thread = null
        track?.runCatching { pause(); flush(); stop() }; track?.release(); track = null
    }
}
