@file:OptIn(ExperimentalMaterial3Api::class)

package com.dscoding.startingpoint.ui.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
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
import androidx.navigation.compose.rememberNavController
import com.dscoding.startingpoint.common.Constants.TOP_APP_BAR_SLIDE_IN_ANIMATION_TARGET_OFFSET
import com.dscoding.startingpoint.ui.navigation.NavGraph
import com.dscoding.startingpoint.utils.extensions.navActions

@Composable
fun MainApp() {
    val navController = rememberNavController()
    val navActions = navController.navActions()
    val state = rememberMainAppState(navController = navController)

    Scaffold(topBar = {
        TopAppBarUI(
            visible = state.shouldShowTopAppBar,
            title = state.currentDestination?.strResource?.asString(),
            showSettingsIcon = state.shouldShowSettingsIcon,
            onSettingsPressed = navActions.goToSettings,
            onBackPressed = navActions.upPress
        )
    }, content = { paddingValues ->
        Surface(modifier = Modifier.padding(paddingValues)) {
            NavGraph(
                navController = navController,
                navActions = navActions,
            )
        }
    })
}

@Composable
fun TopAppBarUI(
    visible: Boolean,
    title: String?,
    showSettingsIcon: Boolean,
    onSettingsPressed: () -> Unit,
    onBackPressed: () -> Unit
) {
    AnimatedVisibility(
        visible = visible,
        enter = slideInVertically(),
        exit = slideOutVertically(targetOffsetY = { TOP_APP_BAR_SLIDE_IN_ANIMATION_TARGET_OFFSET })
    ) {
        TopAppBar(title = {
            Text(
                text = title ?: "",
                color = White,
                style = MaterialTheme.typography.titleMedium
            )
        }, navigationIcon = {
            IconButton(onClick = onBackPressed) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Go back icon",
                    tint = White
                )
            }
        },
            actions = {
                AnimatedVisibility(
                    visible = showSettingsIcon,
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    IconButton(onClick = onSettingsPressed) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Settings Icon",
                            tint = White
                        )
                    }
                }
            }
        )
    }
}


