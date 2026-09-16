package com.sesi.astralia.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.savedstate.read
import com.sesi.astralia.ui.screens.CategoryScreen
import com.sesi.astralia.ui.screens.ContentScreen
import com.sesi.astralia.ui.screens.SubCategoryScreen

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
            CategoryScreen(navController = rootNavController)
        }
        composable(
            route = Routes.SubCategory.route,
            arguments = listOf(navArgument("categoryId") { type = NavType.LongType })
        ) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.read {
                getLong("categoryId")
            } ?:0L
            val categoryName = backStackEntry.arguments?.read {
                getString("categoryName")
            } ?:""
            val categoryDescription = backStackEntry.arguments?.read {
                getString("categoryDescription")
            } ?:""
            SubCategoryScreen(navController = rootNavController, categoryId = categoryId, categoryName = categoryName, categoryDescription = categoryDescription)
        }
        composable(
            route = Routes.Content.route,
            arguments = listOf(navArgument("subCategoryId") { type = NavType.LongType })
        ) {
            val subCategoryId = it.arguments?.read {
                getLong("subCategoryId")
            } ?:0L
            ContentScreen(navController = rootNavController, subCategoryId = subCategoryId)
        }


    }
}