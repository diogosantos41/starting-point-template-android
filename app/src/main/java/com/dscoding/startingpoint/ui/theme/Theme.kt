package com.dscoding.startingpoint.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

const val strongOpacity = 0.6f
const val slightOpacity = 0.87f

private val LightColors = lightColorScheme(
    primary = Coral,
    onPrimary = DarkGrey,
    secondary = DirtyWhite,
    background = DirtyWhite,
    onBackground = DarkGrey,
    surface = DirtyWhite,
    onSurface = DarkGrey,
    primaryContainer = DirtyWhite
)

private val DarkColors = darkColorScheme(
    primary = Coral,
    onPrimary = White,
    secondary = DarkGrey,
    background = DarkGrey,
    onBackground = White,
    surface = DarkGrey,
    onSurface = White,
    primaryContainer = DarkerGrey
)

@Composable
fun StartingPointTheme(
    content: @Composable () -> Unit
) {
    val colors = if (isSystemInDarkTheme()) DarkColors else LightColors
    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}