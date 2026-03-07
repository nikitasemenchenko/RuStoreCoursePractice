package com.example.rustorecoursepractice.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rustorecoursepractice.appDetails.AppDetailsScreen
import com.example.rustorecoursepractice.appList.AppListScreen
import com.example.rustorecoursepractice.appList.getAppById
import com.example.rustorecoursepractice.appList.getApps

sealed class Screen(
    val route: String
) {
    object General : Screen("general")
    data class AppDetails(val id: Int) : Screen("appDetails/$id") {
        companion object {
            const val route = "appDetails/{id}"
        }
    }
}

@Composable
fun NavHost(
    navController: NavHostController
) {
    val apps = getApps()

    NavHost(
        navController = navController,
        startDestination = Screen.General.route
    ) {
        composable(Screen.General.route) {
            AppListScreen(
                apps,
                onAppClick = { id ->
                    navController.navigate(Screen.AppDetails(id).route)
                }
            )
        }
        composable(Screen.AppDetails.route) {
            val id = it.arguments?.getString("id")?.toInt() ?: 1
            val app = getAppById(id)
            AppDetailsScreen(
                app = app,
                onBackClick = {
                    navController.navigate(Screen.General.route)
                }
            )
        }
    }
}