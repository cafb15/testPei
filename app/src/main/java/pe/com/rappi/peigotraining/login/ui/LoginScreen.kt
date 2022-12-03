package pe.com.rappi.peigotraining.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import pe.com.rappi.peigotraining.R
import pe.com.rappi.peigotraining.ui.components.BorderButton
import pe.com.rappi.peigotraining.ui.components.PrimaryButton
import pe.com.rappi.peigotraining.ui.theme.PeiGoTheme
import pe.com.rappi.peigotraining.ui.theme.PeiGoTrainingTheme

@Composable
fun LoginScreen() {
    ConstraintLayout(
        createConstraintSet(),
        modifier = Modifier
            .fillMaxSize()
            .background(PeiGoTheme.colors.primary)
    ) {
        Box(
            modifier = Modifier.layoutId("background")
        ) {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.im_city),
                contentDescription = "dd",
                modifier = Modifier
                    .padding(top = 20.dp)
                    .align(alignment = Alignment.BottomStart)
            )
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.im_plants),
                contentDescription = "",
                modifier = Modifier
                    .padding(top = 20.dp)
                    .align(alignment = Alignment.BottomEnd)
            )
        }

        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_peigo_logo_white),
            contentDescription = "",
            modifier = Modifier
                .layoutId("logo")
                .padding(top = 16.dp)
        )

        Box(
            modifier = Modifier
                .layoutId("boxOptions")
                .background(Color.White)
        ) {
            ConstraintLayout(
                createConstraintSetBox(),
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = stringResource(id = R.string.vive_bacan),
                    modifier = Modifier.layoutId("viveBacan"),
                    style = PeiGoTheme.typography.h2Bold,
                )
                Text(
                    text = stringResource(id = R.string.safe_money),
                    modifier = Modifier
                        .layoutId("safeMoney")
                        .padding(horizontal = 16.dp),
                    style = PeiGoTheme.typography.h4,
                    textAlign = TextAlign.Center
                )
                PrimaryButton(
                    onClick = { /*TODO*/ },
                    text = stringResource(id = R.string.sign_up_peigo),
                    modifier = Modifier.layoutId("registerButton")
                )
                BorderButton(
                    onClick = { /*TODO*/ },
                    text = stringResource(id = R.string.sign_in),
                    modifier = Modifier.layoutId("loginButton")
                )
            }
        }

        Image(
            painter = painterResource(id = R.mipmap.im_casual_life),
            contentDescription = "",
            modifier = Modifier.layoutId("person")
        )
    }
}

private fun createConstraintSet(): ConstraintSet = ConstraintSet {
    val topGuideline = createGuidelineFromTop(0.63f)

    val background = createRefFor("background")
    val imageLogo = createRefFor("logo")
    val imagePerson = createRefFor("person")
    val boxOptions = createRefFor("boxOptions")

    constrain(background) {
        width = Dimension.fillToConstraints

        end.linkTo(parent.end)
        start.linkTo(parent.start)
        bottom.linkTo(topGuideline, margin = 53.dp)
    }

    constrain(imageLogo) {
        top.linkTo(parent.top)
        end.linkTo(parent.end)
        start.linkTo(parent.start)
    }

    constrain(imagePerson) {
        end.linkTo(parent.end)
        start.linkTo(parent.start)
        bottom.linkTo(topGuideline)
    }

    constrain(boxOptions) {
        width = Dimension.fillToConstraints
        height = Dimension.fillToConstraints

        top.linkTo(background.bottom)
        end.linkTo(parent.end)
        start.linkTo(parent.start)
        bottom.linkTo(parent.bottom)
    }
}

private fun createConstraintSetBox(): ConstraintSet  = ConstraintSet {
    val viveBacan = createRefFor("viveBacan")
    val safeMoney = createRefFor("safeMoney")
    val registerButton = createRefFor("registerButton")
    val loginButton = createRefFor("loginButton")

    val verticalChain = createVerticalChain(viveBacan, safeMoney, registerButton, loginButton, chainStyle = ChainStyle.Spread)

    constrain(verticalChain) {
        top.linkTo(parent.top, margin = 60.dp)
        bottom.linkTo(parent.bottom, margin = 20.dp)
    }

    constrain(viveBacan) {
        top.linkTo(parent.top)
        end.linkTo(parent.end)
        start.linkTo(parent.start)
        bottom.linkTo(safeMoney.top)
    }

    constrain(safeMoney) {
        top.linkTo(viveBacan.bottom)
        end.linkTo(parent.end)
        start.linkTo(parent.start)
        bottom.linkTo(registerButton.top)
    }

    constrain(registerButton) {
        width = Dimension.fillToConstraints

        top.linkTo(safeMoney.bottom)
        end.linkTo(parent.end, margin = 20.dp)
        start.linkTo(parent.start, margin = 20.dp)
        bottom.linkTo(loginButton.top, margin = 20.dp)
    }

    constrain(loginButton) {
        width = Dimension.fillToConstraints

        top.linkTo(registerButton.bottom, margin = 20.dp)
        end.linkTo(registerButton.end)
        start.linkTo(registerButton.start)
        bottom.linkTo(parent.bottom)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PeiGoTrainingTheme(isPreview = true) {
        LoginScreen()
    }
}