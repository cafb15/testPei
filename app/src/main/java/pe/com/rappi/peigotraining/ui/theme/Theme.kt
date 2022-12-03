package pe.com.rappi.peigotraining.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

object PeiGoTheme {

    val colors: PeiGoColors
        @Composable
        get() = LocalPeiGoColors.current

    val typography: PeiGoTypography
        @Composable
        get() = LocalPeiGoTypography.current
}

@Composable
fun PeiGoTrainingTheme(
    isPreview: Boolean = false,
    darkTheme: Boolean = isSystemInDarkTheme(),
    statusBarColor: Color = PeiGoTheme.colors.primary,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    if (isPreview.not()) {
        val systemUiController = rememberSystemUiController()

        SideEffect {
            systemUiController.setStatusBarColor(
                color = statusBarColor,
                darkIcons = true
            )
        }
    }

    CompositionLocalProvider(
        LocalPeiGoColors provides PeiGoTheme.colors,
        LocalPeiGoTypography provides PeiGoTheme.typography
    ) {
        MaterialTheme(
            colors = colors,
            shapes = Shapes,
            content = content
        )
    }
}