package com.example.todoapptrail.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFFFA500), // Orange
    secondary = Color(0xFFFFA500).copy(alpha = 0.8f), // Blurred orange
    tertiary = Color(0xFFFFA500).copy(alpha = 0.6f), // More blurred orange
    background = Color.Black, // Black background
    surface = Color.Black.copy(alpha = 0.95f), // Semi-transparent black
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onTertiary = Color.Black,
    onBackground = Color(0xFFFFA500).copy(alpha = 0.8f), // Blurry orange text
    onSurface = Color(0xFFFFA500).copy(alpha = 0.8f), // Blurry orange text
    outline = Color(0xFFFFA500).copy(alpha = 0.2f), // Subtle orange outline
    inversePrimary = Color(0xFFFFA500),
    inverseOnSurface = Color.Black,
    inverseSurface = Color(0xFFFFA500).copy(alpha = 0.2f)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFFFA500),
    secondary = Color(0xFFFFA500).copy(alpha = 0.8f),
    tertiary = Color(0xFFFFA500).copy(alpha = 0.6f),
    background = Color.Black,
    surface = Color.Black.copy(alpha = 0.95f),
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onTertiary = Color.Black,
    onBackground = Color(0xFFFFA500).copy(alpha = 0.8f),
    onSurface = Color(0xFFFFA500).copy(alpha = 0.8f),
    outline = Color(0xFFFFA500).copy(alpha = 0.2f),
    inversePrimary = Color(0xFFFFA500),
    inverseOnSurface = Color.Black,
    inverseSurface = Color(0xFFFFA500).copy(alpha = 0.2f)
)

@Composable
fun ToDoAppTrailTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = DarkColorScheme // Always use dark theme with black background
    
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.background.hashCode()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}