package pe.com.rappi.peigotraining.movements.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import pe.com.rappi.peigotraining.R
import pe.com.rappi.peigotraining.ui.theme.PeiGoTrainingTheme

@Composable
fun MovementsScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            ConstraintLayout(
                constraintSet = constraintSetTopAppBar(),
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    modifier = Modifier.layoutId("image"),
                    contentScale = ContentScale.Crop,
                    imageVector = ImageVector.vectorResource(id = R.drawable.im_small_header),
                    contentDescription = ""
                )
                TopAppBar(
                    modifier = Modifier
                        .layoutId("topAppBar")
                        .statusBarsPadding(),
                    title = { Text(text = "Tu actividad") },
                    backgroundColor = Color.Transparent,
                    elevation = 0.dp
                )
            }
        },
    ) { paddingValues ->
        LazyColumn(
            contentPadding = PaddingValues(all = 16.dp)
        ) {
            items(
                items = listOf("", ""),
                itemContent = {
                    MovementItem()
                }
            )
        }

        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
        }
    }
}

private fun constraintSetTopAppBar(): ConstraintSet = ConstraintSet {
    val image = createRefFor("image")
    val topAppBar = createRefFor("topAppBar")

    constrain(image) {
        width = Dimension.fillToConstraints
        height = Dimension.fillToConstraints

        top.linkTo(parent.top)
        end.linkTo(parent.end)
        start.linkTo(parent.start)
        bottom.linkTo(topAppBar.bottom)
    }

    constrain(topAppBar) {
        width = Dimension.fillToConstraints

        top.linkTo(parent.top)
        end.linkTo(parent.end)
        start.linkTo(parent.start)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PeiGoTrainingTheme(isPreview = true) {
        MovementsScreen()
    }
}