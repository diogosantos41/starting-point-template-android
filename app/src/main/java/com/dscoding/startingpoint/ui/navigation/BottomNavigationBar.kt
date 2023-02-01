package com.dscoding.startingpoint.ui.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dscoding.startingpoint.ui.theme.DirtyWhite
import com.dscoding.startingpoint.ui.theme.White

@Composable
fun BottomNavigationBar(
    selectedDestination: TopLevelDestination,
    navigateToTopLevelDestination: (TopLevelDestination) -> Unit
) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primary)
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = CenterVertically
    ) {

        TopLevelDestinations.forEach { destination ->
            BottomNavigationItem(
                selected = selectedDestination.route == destination.route,
                onClick = { navigateToTopLevelDestination(destination) },
                destination = destination
            )
        }
    }
}


@Composable
fun BottomNavigationItem(
    selected: Boolean,
    onClick: () -> Unit,
    destination: TopLevelDestination,
) {

    val background =
        if (selected) DirtyWhite.copy(alpha = 0.2f) else Color.Transparent
    val contentColor =
        if (selected) White else White

    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(background)
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp),
            verticalAlignment = CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = if (selected) destination.selectedIcon else destination.unselectedIcon,
                contentDescription = destination.title,
                tint = contentColor
            )

            AnimatedVisibility(visible = selected) {
                Text(
                    text = destination.title,
                    color = contentColor,
                    fontWeight = FontWeight.Bold
                )
            }

        }
    }
}