package com.dscoding.startingpoint.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dscoding.startingpoint.ui.productlist.ProductListScreen
import com.dscoding.startingpoint.ui.utils.navActions
import com.dscoding.startingpoint.ui.welcome.WelcomeScreen


@Composable
fun NavGraph(startDestination: String = Destination.WelcomeScreen.route) {
    val navController = rememberNavController()
    val navActions = navController.navActions()

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
    }
}


class NavActions(navController: NavController) {

    val upPress: () -> Unit = {
        navController.navigateUp()
    }

    val goToProductList: () -> Unit = {
        navController.navigate(Destination.ProductListScreen.route)
    }

    val goToProductDetail: (String) -> Unit = { productId ->

    }
}
