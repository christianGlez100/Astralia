package com.sesi.astralia.shared

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import platform.UIKit.UIApplication
import platform.UIKit.UIStatusBarStyleDarkContent
import platform.UIKit.UIStatusBarStyleLightContent
import platform.UIKit.setStatusBarStyle

class IosStatusBar : StatusBar {
    @Composable
    override fun setStatusBar(isDark: Boolean) {
        SideEffect {
            UIApplication.sharedApplication.setStatusBarStyle(
                if (isDark) UIStatusBarStyleLightContent else UIStatusBarStyleDarkContent
            )
        }
    }
}

@Composable
actual fun getStatusBar(): StatusBar = IosStatusBar()