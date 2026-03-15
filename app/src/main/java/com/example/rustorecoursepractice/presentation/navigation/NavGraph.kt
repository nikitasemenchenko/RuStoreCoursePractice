package com.example.rustorecoursepractice.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rustorecoursepractice.presentation.appDetails.AppDetails
import com.example.rustorecoursepractice.presentation.appList.AppListScreen

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

    NavHost(
        navController = navController,
        startDestination = Screen.General.route
    ) {
        composable(Screen.General.route) {
            AppListScreen(
                onAppClick = { id ->
                    navController.navigate(Screen.AppDetails(id).route)
                }
            )
        }
        composable(Screen.AppDetails.route) {
            val id = it.arguments?.getString("id")?.toInt() ?: 1
            AppDetails(
                appId = id,
                onBackClick = {
                    navController.navigate(Screen.General.route)
                }
            )
        }
    }
}