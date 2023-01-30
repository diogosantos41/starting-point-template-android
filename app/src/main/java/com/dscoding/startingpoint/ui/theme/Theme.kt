package com.dscoding.startingpoint.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

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
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colors.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}