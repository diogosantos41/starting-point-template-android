package com.dscoding.startingpoint.ui.common_components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dscoding.startingpoint.ui.theme.DarkerGrey
import com.dscoding.startingpoint.ui.theme.slightOpacity

@Composable
fun LoadingIndicator(visible: Boolean) {
    if (visible) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(DarkerGrey.copy(alpha = slightOpacity)),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                modifier = Modifier.size(70.dp),
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}