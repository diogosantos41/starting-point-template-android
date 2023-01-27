package com.dscoding.startingpoint.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import com.dscoding.startingpoint.ui.navigation.NavGraph
import com.dscoding.startingpoint.ui.theme.StartingPointTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StartingPointTheme {
                Surface(modifier = Modifier.background(color = MaterialTheme.colorScheme.surface)) {
                    NavGraph()
                }
            }
        }
    }
}