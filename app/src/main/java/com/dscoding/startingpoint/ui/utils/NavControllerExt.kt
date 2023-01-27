package com.dscoding.startingpoint.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.dscoding.startingpoint.ui.navigation.NavActions

fun NavController.safeNavigate(destinationRoute: String) {
    if (this.currentDestination?.route != destinationRoute) {
        this.navigate(destinationRoute)
    }
}

@Composable
fun NavController.navActions(): NavActions {
    return remember(this) { NavActions(this) }
}