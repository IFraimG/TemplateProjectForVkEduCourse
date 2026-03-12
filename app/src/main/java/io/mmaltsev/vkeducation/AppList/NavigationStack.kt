package io.mmaltsev.vkeducation.AppList

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.mmaltsev.vkeducation.AppDetailsScreen

@Composable
fun NavigationStack() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Main.route) {
        composable(route = Screen.Main.route) {
            AppListScreen(navController = navController)
        }

        composable(route = Screen.Detail.route) {
            AppDetailsScreen(navController = navController)
        }

    }

}