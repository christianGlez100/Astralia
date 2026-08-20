package com.sesi.astralia.ui.navigation

import astralia.shared.generated.resources.Res
import astralia.shared.generated.resources.ic_stars
import astralia.shared.generated.resources.ic_stars_off
import astralia.shared.generated.resources.ic_user_off
import astralia.shared.generated.resources.ic_user_on
import com.sesi.astralia.ui.composables.NavigationItem

object Graph {
    const val NAVIGATION_BAR_SCREEN_GRAPH = "navigationBarScreenGraph"
}

sealed class Routes(var route: String) {
    data object Home : Routes("home")
    data object SignIn : Routes("SignIn")
    data object LogIn : Routes("login")
    data object Profile: Routes("profile")
    data object HomeDetail : Routes("homeDetail")
    data object CreateQuiz : Routes("createQuiz")
    data object SettingDetail : Routes("settingDetail")
}

val navigationItemsLists = listOf(
    NavigationItem(
        unSelectedIcon = Res.drawable.ic_stars_off,
        selectedIcon = Res.drawable.ic_stars,
        title = "Descubrir",
        route = Routes.Home.route,
    ),
    NavigationItem(
        unSelectedIcon = Res.drawable.ic_user_off,
        selectedIcon = Res.drawable.ic_user_on,
        title = "Perfil",
        route = Routes.Profile.route,
    )
)