package com.dscoding.startingpoint.ui.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.dscoding.startingpoint.ui.navigation.BottomNavigationBar
import com.dscoding.startingpoint.ui.navigation.NavGraph
import com.dscoding.startingpoint.ui.theme.DarkerGrey
import com.dscoding.startingpoint.ui.theme.slightOpacity
import com.dscoding.startingpoint.ui.utils.navActions
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpApp(viewModel: MainViewModel = hiltViewModel()) {

    val state = viewModel.uiState.value
    val navController = rememberNavController()
    val navActions = navController.navActions(viewModel::onBoardingCompleted)

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is UiEvent.NavigateTo -> {
                    navActions.navigateTopLevelDestination(event.destination)
                }
            }
        }
    }

    Scaffold(
        bottomBar = {
            AnimatedVisibility(visible = state.showBottomBar) {
                BottomNavigationBar(
                    selectedDestination = state.currentTopLevelDestination,
                    navigateToTopLevelDestination = viewModel::navigateTo,
                )
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            NavGraph(
                navController = navController,
                navActions = navActions,
                showLoading = viewModel::showLoading
            )
        }
    }

    if (state.showLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(DarkerGrey.copy(alpha = slightOpacity)),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                modifier = Modifier.size(100.dp),
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}