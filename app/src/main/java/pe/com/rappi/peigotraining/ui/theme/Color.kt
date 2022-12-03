package pe.com.rappi.peigotraining.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

private val Coral = Color(0xFFFF6A5F)
private val Navy = Color(0xFF141644)
private val Aqua = Color(0xFF00DDD8)

@Immutable
data class PeiGoColors(
    val primary: Color = Aqua,
    val secondary: Color = Coral,
    val textButton: Color = Navy
)

internal val LocalPeiGoColors = staticCompositionLocalOf { PeiGoColors() }