package pe.com.rappi.peigotraining.movements.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import pe.com.rappi.peigotraining.R
import pe.com.rappi.peigotraining.ui.theme.PeiGoTheme
import pe.com.rappi.peigotraining.ui.theme.PeiGoTrainingTheme

@Composable
fun MovementDetailScreen() {
    ConstraintLayout(
        constraintSetMovementDetail(),
        modifier = Modifier
            .fillMaxSize()
            .background(color = PeiGoTheme.colors.primary)
    ) {
        Image(
            modifier = Modifier.layoutId("imageHeader"),
            imageVector = ImageVector.vectorResource(id = R.drawable.bg_movements_detail),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.layoutId("backButton")
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_close_peigo),
                contentDescription = ""
            )
        }
        Image(
            modifier = Modifier.layoutId("imageDrone")
                .size(150.dp),
            painter = painterResource(id = R.mipmap.im_drone),
            contentDescription = ""
        )
    }
}

private fun constraintSetMovementDetail(): ConstraintSet = ConstraintSet {
    val imageHeader = createRefFor("imageHeader")
    val backButton = createRefFor("backButton")
    val imageDrone = createRefFor("imageDrone")

    constrain(imageHeader) {
        width = Dimension.fillToConstraints

        top.linkTo(parent.top)
        end.linkTo(parent.end)
        start.linkTo(parent.start)
    }

    constrain(backButton) {
        top.linkTo(parent.top, margin = 16.dp)
        end.linkTo(parent.end, margin = 16.dp)
    }

    constrain(imageDrone) {
        top.linkTo(imageHeader.bottom)
        end.linkTo(parent.end)
        start.linkTo(parent.start)
    }
}

@Preview(showBackground = true)
@Composable
fun MovementDetailPreview() {
    PeiGoTrainingTheme(isPreview = true) {
        MovementDetailScreen()
    }
}