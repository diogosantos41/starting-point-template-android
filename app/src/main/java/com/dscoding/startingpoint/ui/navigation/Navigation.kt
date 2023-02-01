package com.dscoding.startingpoint.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dscoding.startingpoint.ui.productlist.ProductListScreen
import com.dscoding.startingpoint.ui.utils.FeatureNotImplementedScreen
import com.dscoding.startingpoint.ui.welcome.WelcomeScreen


@Composable
fun NavGraph(
    startDestination: String = Destination.WelcomeScreen.route,
    navController: NavHostController,
    navActions: NavActions
) {

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(
            route = Destination.WelcomeScreen.route,
        ) {
            WelcomeScreen(navActions)
        }
        composable(
            route = Destination.ProductListScreen.route,
        ) {
            ProductListScreen(navActions)
        }
        composable(
            route = Destination.ComponentsScreen.route,
        ) {
            FeatureNotImplementedScreen("Components")
        }
        composable(
            route = Destination.FormScreen.route,
        ) {
            FeatureNotImplementedScreen("Form")
        }
        composable(
            route = Destination.SettingsScreen.route,
        ) {
            FeatureNotImplementedScreen("Settings")
        }
    }
}


class NavActions(private val navController: NavController, onBoardingCompleted: () -> Unit) {

    val upPress: () -> Unit = {
        navController.navigateUp()
    }

    val goToProductList: () -> Unit = {
        navController.navigate(Destination.ProductListScreen.route)
    }

    val goToProductDetail: (String) -> Unit = { productId ->

    }

    val onBoardingCompleted: () -> Unit = {
        navController.popBackStack()
        onBoardingCompleted()
    }

    fun navigateTopLevelDestination(destination: TopLevelDestination) {
        navController.navigate(destination.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}
