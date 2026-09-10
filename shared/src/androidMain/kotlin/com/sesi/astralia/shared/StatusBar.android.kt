package com.sesi.astralia.shared

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowInsetsControllerCompat

class AndroidStatusBar : StatusBar {
    @Composable
    override fun setStatusBar(isDark: Boolean) {
        val view = LocalView.current
        if (!view.isInEditMode) {
            SideEffect {
                val window = (view.context as Activity).window
                val controller = WindowInsetsControllerCompat(window, view)
                controller.isAppearanceLightStatusBars = !isDark
            }
        }
    }
}

@Composable
actual fun getStatusBar(): StatusBar = AndroidStatusBar()