package com.dscoding.startingpoint.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destination(val route: String) {
    object WelcomeScreen : Destination("welcome_screen")
    object ProductListScreen : Destination("product_list_screen")
    object ComponentsScreen : Destination("components_screen")
    object FormScreen : Destination("form_screen")
    object SettingsScreen : Destination("settings_screen")

    /* object AddEditNoteScreen : Screen("add_edit_note_screen") {
         fun withArgs(noteId: String, noteColor: String) =
             "$route?$NOTE_ID_ARG=$noteId&$NOTE_COLOR_ARG=$noteColor"
     } */
}

data class TopLevelDestination(
    val route: String,
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
)

val ListTopLevelDestination = TopLevelDestination(
    route = Destination.ProductListScreen.route,
    title = "List",
    selectedIcon = Icons.Default.List,
    unselectedIcon = Icons.Default.List,
)

val ComponentsTopLevelDestination = TopLevelDestination(
    route = Destination.ComponentsScreen.route,
    title = "Components",
    selectedIcon = Icons.Default.Info,
    unselectedIcon = Icons.Default.Info,
)

val FormTopLevelDestination = TopLevelDestination(
    route = Destination.FormScreen.route,
    title = "Form",
    selectedIcon = Icons.Outlined.Edit,
    unselectedIcon = Icons.Outlined.Edit,
)

val SettingsTopLevelDestination = TopLevelDestination(
    route = Destination.SettingsScreen.route,
    title = "Settings",
    selectedIcon = Icons.Default.Settings,
    unselectedIcon = Icons.Default.Settings,
)

val TopLevelDestinations = listOf(
    ListTopLevelDestination,
    ComponentsTopLevelDestination,
    FormTopLevelDestination,
    SettingsTopLevelDestination
)