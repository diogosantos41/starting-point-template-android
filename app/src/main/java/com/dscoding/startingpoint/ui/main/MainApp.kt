package com.dscoding.startingpoint.ui.main

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.dscoding.startingpoint.ui.navigation.NavGraph
import com.dscoding.startingpoint.ui.utils.navActions

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainApp(viewModel: MainUIViewModel = hiltViewModel()) {

    val state = viewModel.uiState.value
    val navController = rememberNavController()
    val navActions = navController.navActions()

    NavGraph(
        navController = navController,
        navActions = navActions
    )
}

