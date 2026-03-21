package com.example.rustorecoursepractice.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rustorecoursepractice.presentation.appDetails.AppDetails
import com.example.rustorecoursepractice.presentation.appList.AppListScreen
import kotlinx.serialization.Serializable

@Serializable
object AppListRoute

@Serializable
data class AppDetailsRoute(val id: String)

@Composable
fun NavHost(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = AppListRoute
    ) {
        composable<AppListRoute> {
            AppListScreen(
                onAppClick = { id ->
                    navController.navigate(AppDetailsRoute(id))
                }
            )
        }
        composable<AppDetailsRoute> {
            AppDetails(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}