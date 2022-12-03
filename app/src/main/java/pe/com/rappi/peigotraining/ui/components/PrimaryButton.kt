package pe.com.rappi.peigotraining.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
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
fun PrimaryButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(10.dp),
    contentPaddingValues: PaddingValues = PaddingValues(top = 16.dp, bottom = 16.dp)
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = shape,
        contentPadding = contentPaddingValues,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = PeiGoTheme.colors.secondary
        )
    ) {
        Text(
            text = text,
            color = PeiGoTheme.colors.textButton,
            style = PeiGoTheme.typography.h4Bold
        )
    }
}