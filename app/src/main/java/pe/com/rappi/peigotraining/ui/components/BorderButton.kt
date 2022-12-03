package pe.com.rappi.peigotraining.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pe.com.rappi.peigotraining.ui.theme.PeiGoTheme
import pe.com.rappi.peigotraining.ui.theme.font

@Composable
fun BorderButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(10.dp),
    border: BorderStroke = BorderStroke(width = 2.dp, color = PeiGoTheme.colors.secondary),
    contentPaddingValues: PaddingValues = PaddingValues(top = 16.dp, bottom = 16.dp)
) {
    OutlinedButton(
        onClick = onClick,
        shape = shape,
        border = border,
        modifier = modifier,
        contentPadding = contentPaddingValues
    ) {
        Text(
            text = text,
            color = PeiGoTheme.colors.textButton,
            style = PeiGoTheme.typography.h4Bold
        )
    }
}