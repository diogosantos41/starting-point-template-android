package com.dscoding.startingpoint.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dscoding.startingpoint.ui.second_screen.SecondScreen
import com.dscoding.startingpoint.ui.utils.FeatureNotImplementedScreen
import com.dscoding.startingpoint.ui.utils.safeNavigate
import com.dscoding.startingpoint.ui.first_screen.FirstScreen


@Composable
fun NavGraph(
    startDestination: String = Destination.FirstScreen.route,
    navController: NavHostController,
    navActions: NavActions
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
            route = Destination.SettingsScreen.route,
        ) {
            FeatureNotImplementedScreen("Components")
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

    val goToProductDetail: (String) -> Unit = { productId ->

    }
}
