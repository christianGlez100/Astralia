package com.sesi.astralia.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sesi.astralia.ui.screens.CategoryScreen
import com.sesi.astralia.ui.screens.HomeScreen
import com.sesi.astralia.ui.theme.CelestialSoulTheme

@Composable
fun MainNavigation(rootNavController: NavHostController, snackbarHostState: SnackbarHostState) {
    NavHost(
        navController = rootNavController,
        startDestination = Routes.Home.route,
        modifier = Modifier.background(
            MaterialTheme.colorScheme.surface
        )
    ) {
        composable(route = Routes.Home.route) {
            //HomeScreen()
            CategoryScreen()
        }

    }
}