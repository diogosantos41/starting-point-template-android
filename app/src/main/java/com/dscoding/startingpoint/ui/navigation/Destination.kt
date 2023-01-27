package com.dscoding.startingpoint.ui.navigation

sealed class Destination(val route: String) {
    object WelcomeScreen : Destination("welcome_screen")
    object ProductListScreen : Destination("product_list_screen")
    object ComponentsScreen : Destination("components_screen")
    object FormScreen : Destination("form_screen")

    /* object AddEditNoteScreen : Screen("add_edit_note_screen") {
         fun withArgs(noteId: String, noteColor: String) =
             "$route?$NOTE_ID_ARG=$noteId&$NOTE_COLOR_ARG=$noteColor"
     } */
}