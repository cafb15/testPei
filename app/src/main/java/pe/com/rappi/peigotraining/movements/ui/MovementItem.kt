package pe.com.rappi.peigotraining.movements.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import pe.com.rappi.peigotraining.R
import pe.com.rappi.peigotraining.ui.theme.PeiGoTheme
import pe.com.rappi.peigotraining.ui.theme.PeiGoTrainingTheme

@Composable
fun MovementItem() {
    ConstraintLayout(
        constraintSetMovement(),
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Box(
            modifier = Modifier.layoutId("avatar")
        ) {
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clip(CircleShape)
                    .background(Color.Blue),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "CF",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    style = PeiGoTheme.typography.h4Bold
                )
            }
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_state_outgoing),
                contentDescription = "",
                modifier = Modifier.align(Alignment.BottomEnd)
            )
        }
        Text(
            modifier = Modifier.layoutId("username"),
            text = "Jhoanna Quintero",
            style = PeiGoTheme.typography.body1
        )
        Text(
            modifier = Modifier.layoutId("movementType"),
            text = "Envío de dinero",
            style = PeiGoTheme.typography.description
        )
        Text(
            modifier = Modifier.layoutId("amount"),
            text = "-$50.00",
            style = PeiGoTheme.typography.h4,
            color = PeiGoTheme.colors.secondary
        )
    }
}

private fun constraintSetMovement(): ConstraintSet {
    return ConstraintSet {
        val avatar = createRefFor("avatar")
        val username = createRefFor("username")
        val movementType = createRefFor("movementType")
        val amount = createRefFor("amount")

        constrain(avatar) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
        }

        constrain(username) {
            width = Dimension.fillToConstraints

            top.linkTo(avatar.top)
            end.linkTo(amount.start)
            bottom.linkTo(movementType.top)
            start.linkTo(avatar.end, margin = 8.dp)
        }

        constrain(movementType) {
            width = Dimension.fillToConstraints

            bottom.linkTo(avatar.bottom)
            end.linkTo(username.end)
            start.linkTo(username.start)
            top.linkTo(username.bottom)
        }

        constrain(amount) {
            top.linkTo(avatar.top)
            end.linkTo(parent.end)
            bottom.linkTo(avatar.bottom)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovementItemPreview() {
    PeiGoTrainingTheme(isPreview = true) {
        MovementItem()
    }
}