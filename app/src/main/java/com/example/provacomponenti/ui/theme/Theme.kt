package com.example.provacomponenti.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkPalette = darkColors(
    primary = Color(0xFFb3c5ff),
    onPrimary = Color(0xFF330099),
    primaryVariant = Color(0xFF4b00d4),
    secondary = Color(0xFF877E9E),
    onSecondary = Color(0xFF322e41),
    surface = Color(0xFF1c1b1e),
    onSurface = Color(0xFFe6e1e6)

)
private val DarkColorPalette = darkColors(
    primary = Color.LightGray,
    secondary = Color.Red, //FAB
    surface = Color.Black,
    onSecondary = Color.White
)
private val LightColorPalette = lightColors(
    primary = Blue_Honda,
    primaryVariant = Color.Blue,
    secondary = Blue_Honda,
//    background = Color.LightGray



    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun ProvaComponentiTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkPalette
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