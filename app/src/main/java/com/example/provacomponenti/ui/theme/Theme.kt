package com.example.provacomponenti.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkBluePalette = darkColors(
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
    secondary = md_theme_dark_secondary,
    onSecondary = md_theme_dark_onSecondary,

    error = md_theme_dark_error,

    onError = md_theme_dark_onError,
    background = md_theme_dark_background,
    onBackground = md_theme_dark_onBackground,
    surface = md_theme_dark_surface,
    onSurface = md_theme_dark_onSurface,
)
private val DarkColorPaletteProva = darkColors(
    primary = Color.LightGray,
    secondary = Color.Red, //FAB
    surface = Color.Black,
    onSecondary = Color.White
)
private val LightColorPalette = lightColors(
    primary = Color(0xFF0055d6),
    onPrimary= Color(0xFFffffff),
    secondary = Color(0xFFbc1515),
    onSecondary = Color(0xFFffffff),
    background = Color(0xFFffffff),
    surface = Color(0xFFDDEAFF)
)
private val DarkColorPalette = darkColors(
    primary = Color(0xFF0055d6),
    onPrimary= Color(0xFFffffff),
    secondary = Color(0xFFbc1515),
    onSecondary = Color(0xFFffffff),
    background = Color(0xFF2B3047),
    surface = Color(0xFF76849B)

)
private val LightBluePalette = lightColors(

    primary = md_theme_light_primary,
    onPrimary = md_theme_light_onPrimary,
    secondary = md_theme_light_secondary,
    onSecondary = md_theme_light_onSecondary,
    error = md_theme_light_error,
    onError = md_theme_light_onError,
    background = md_theme_light_background,
    onBackground = md_theme_light_onBackground,
    surface = md_theme_light_surface,
    onSurface = md_theme_light_onSurface,
)

@Composable
fun ProvaComponentiTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}