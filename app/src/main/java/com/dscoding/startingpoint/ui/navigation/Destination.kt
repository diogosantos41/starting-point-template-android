package com.dscoding.startingpoint.ui.navigation

import com.dscoding.startingpoint.R
import com.dscoding.startingpoint.common.StringResource

sealed class Destination(val strResource: StringResource? = null, val route: String) {
    object FirstScreen : Destination(
        route = "first_screen"
    )

    object SecondScreen : Destination(
        strResource = StringResource(resId = R.string.second_screen_page_title),
        route = "second_screen"
    )

    object ThirdScreen : Destination(
        strResource = StringResource(resId = R.string.third_screen_page_title),
        route = "third_screen"
    )

    object SettingsScreen : Destination(
        strResource = StringResource(resId = R.string.settings_screen_page_title),
        route = "settings_screen"
    )
}

val StartDestination = Destination.FirstScreen

fun String.toDestination(): Destination? {
    return when (this) {
        Destination.FirstScreen.route -> Destination.FirstScreen
        Destination.SecondScreen.route -> Destination.SecondScreen
        Destination.ThirdScreen.route -> Destination.ThirdScreen
        Destination.SettingsScreen.route -> Destination.SettingsScreen
        else -> null
    }
}



