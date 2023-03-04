package com.dscoding.startingpoint.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dscoding.startingpoint.ui.screens.first.FirstScreen
import com.dscoding.startingpoint.ui.screens.second.SecondScreen
import com.dscoding.startingpoint.ui.utils.FeatureNotImplementedScreen
import com.dscoding.startingpoint.ui.utils.safeNavigate

@Composable
fun NavGraph(
    startDestination: String = StartDestination.route,
    navController: NavHostController,
    navActions: NavActions,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(
            route = Destination.FirstScreen.route,
        ) {
            FirstScreen(navActions)
        }
        composable(
            route = Destination.SecondScreen.route,
        ) {
            SecondScreen(navActions)
        }
        composable(
            route = Destination.ThirdScreen.route,
        ) {
            FeatureNotImplementedScreen("Third Screen")
        }
        composable(
            route = Destination.SettingsScreen.route,
        ) {
            FeatureNotImplementedScreen("Settings")
        }
    }
}

class NavActions(private val navController: NavController) {

    val upPress: () -> Unit = {
        navController.navigateUp()
    }

    val goToSecondScreen: () -> Unit = {
        navController.safeNavigate(Destination.SecondScreen.route)
    }

    val goToThirdScreen: () -> Unit = {
        navController.safeNavigate(Destination.ThirdScreen.route)
    }

    val goToSettings: () -> Unit = {
        navController.safeNavigate(Destination.SettingsScreen.route)
    }

    val goToProductDetail: (String) -> Unit = { productId ->

    }
}
