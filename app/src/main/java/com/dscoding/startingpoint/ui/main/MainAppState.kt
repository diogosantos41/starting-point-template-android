package com.dscoding.startingpoint.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dscoding.startingpoint.ui.navigation.Destination
import com.dscoding.startingpoint.ui.navigation.toDestination

@Composable
fun rememberMainAppState(navController: NavHostController = rememberNavController()) =
    remember(navController) {
        MainAppState(navController)
    }

@Stable
class MainAppState(private val navController: NavHostController) {

    private val topAppBarRoutes = listOf(
        Destination.SecondScreen.route,
        Destination.SettingsScreen.route
    )

    private val currentNavDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val shouldShowTopAppBar: Boolean
        @Composable get() = currentNavDestination?.route in topAppBarRoutes

    val currentDestination: Destination?
        @Composable get() = currentNavDestination?.route?.toDestination()


}