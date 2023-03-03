@file:OptIn(ExperimentalMaterial3Api::class)

package com.dscoding.startingpoint.ui.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.dscoding.startingpoint.ui.navigation.NavGraph
import com.dscoding.startingpoint.ui.utils.navActions

@Composable
fun MainApp(viewModel: MainUIViewModel = hiltViewModel()) {

    val state = viewModel.uiState.value
    val navController = rememberNavController()
    val navActions = navController.navActions()


    Scaffold(topBar = {
        TopAppBarUI(onBackPressed = navActions.upPress)
    }, content = { paddingValues ->
        Surface(modifier = Modifier.padding(paddingValues)) {
            NavGraph(
                navController = navController,
                navActions = navActions
            )
        }
    })
}

@Composable
fun TopAppBarUI(onBackPressed: () -> Unit) {
    TopAppBar(title = {
        Text(
            text = "Page Title",
            color = White,
            style = MaterialTheme.typography.headlineSmall
        )
    }, navigationIcon = {
        IconButton(onClick = onBackPressed) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Go back icon",
                tint = White
            )
        }
    })
}

