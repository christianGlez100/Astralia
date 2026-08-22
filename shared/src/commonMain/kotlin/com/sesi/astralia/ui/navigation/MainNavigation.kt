package com.sesi.astralia.ui.navigation

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sesi.astralia.ui.screens.HomeScreen

@Composable
fun MainNavigation(rootNavController: NavHostController,  snackbarHostState: SnackbarHostState) {
    NavHost(navController = rootNavController, startDestination = Routes.Home.route) {
        composable(route = Routes.Home.route) {
            HomeScreen()
        }

    }
}