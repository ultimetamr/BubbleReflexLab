package com.pico.swan.bubblereflex.platform

import android.app.Application
import com.pico.spatial.ui.foundation.dsl.launch
import com.pico.swan.bubblereflex.mainApp

class SpatialApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        launch(::mainApp)
    }
}
