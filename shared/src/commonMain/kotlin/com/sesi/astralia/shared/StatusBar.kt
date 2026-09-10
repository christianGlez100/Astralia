package com.sesi.astralia.shared

import androidx.compose.runtime.Composable

interface StatusBar {
    @Composable
    fun setStatusBar(isDark: Boolean)
}

@Composable
expect fun getStatusBar(): StatusBar