package com.dscoding.startingpoint.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destination(val route: String) {
    object FirstScreen : Destination("first_screen")
    object SecondScreen : Destination("second_screen")
    object SettingsScreen : Destination("settings_screen")

    /* object AddEditNoteScreen : Screen("add_edit_note_screen") {
         fun withArgs(noteId: String, noteColor: String) =
             "$route?$NOTE_ID_ARG=$noteId&$NOTE_COLOR_ARG=$noteColor"
     } */
}

