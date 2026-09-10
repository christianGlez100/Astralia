package com.sesi.astralia.shared

import androidx.compose.runtime.Composable

class WasmJsStatusBar : StatusBar {
    @Composable
    override fun setStatusBar(isDark: Boolean) {
        // No-op for web
    }
}

@Composable
actual fun getStatusBar(): StatusBar = WasmJsStatusBar()