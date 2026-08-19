package com.pico.swan.bubblereflex.platform

import android.content.pm.PackageManager
import android.os.Bundle
import com.pico.spatial.ui.platform.stub.SpatialLaunchActivity

object LaunchOptions { @Volatile var captureMode: String? = null }

class LaunchActivity : SpatialLaunchActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        LaunchOptions.captureMode = intent.getStringExtra("captureMode")
        super.onCreate(savedInstanceState)
        if (checkSelfPermission(HAND_TRACKING_PERMISSION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf(HAND_TRACKING_PERMISSION), HAND_TRACKING_REQUEST)
        }
    }

    private companion object {
        const val HAND_TRACKING_PERMISSION = "com.picovr.permission.HAND_TRACKING"
        const val HAND_TRACKING_REQUEST = 41
    }
}
