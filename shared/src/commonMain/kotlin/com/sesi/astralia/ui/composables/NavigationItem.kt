package com.sesi.astralia.ui.composables

import androidx.compose.ui.graphics.vector.ImageVector
import org.jetbrains.compose.resources.DrawableResource

data class NavigationItem(
    val unSelectedIcon: DrawableResource /* or  DrawableResource*/,
    val selectedIcon: DrawableResource /* or  DrawableResource*/,
    val title: String /* or  StringResource  */,
    val route : String
)