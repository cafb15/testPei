package pe.com.rappi.peigotraining.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import pe.com.rappi.peigotraining.R

val font = FontFamily(
    Font(R.font.ubuntu_light, weight = FontWeight.Light),
    Font(R.font.ubuntu_regular, weight = FontWeight.Normal),
    Font(R.font.ubuntu_bold, weight = FontWeight.Bold)
)

@Immutable
data class PeiGoTypography(
    val body1: TextStyle = TextStyle(
        fontSize = 16.sp,
        fontFamily = font,
        fontWeight = FontWeight.Normal
    ),
    val description: TextStyle = TextStyle(
        fontSize = 14.sp,
        fontFamily = font,
        fontWeight = FontWeight.Normal
    ),
    val h2Bold: TextStyle = TextStyle(
        fontSize = 22.sp,
        fontFamily = font,
        fontWeight = FontWeight.Bold
    ),
    val h4: TextStyle = TextStyle(
        fontSize = 18.sp,
        fontFamily = font,
        fontStyle = FontStyle.Normal
    ),
    val h4Bold: TextStyle = TextStyle(
        fontSize = 18.sp,
        fontFamily = font,
        fontWeight = FontWeight.Bold
    )
)

internal val LocalPeiGoTypography = staticCompositionLocalOf { PeiGoTypography() }