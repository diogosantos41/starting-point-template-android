package com.dscoding.startingpoint.ui.screens.first

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.dscoding.startingpoint.R
import com.dscoding.startingpoint.ui.navigation.NavActions
import com.dscoding.startingpoint.ui.theme.StartingPointTheme
import com.dscoding.startingpoint.ui.utils.DevicePreview
import com.dscoding.startingpoint.ui.utils.navActions
import com.dscoding.startingpoint.ui.utils.supportWideScreen

@Composable
fun FirstScreen(navActions: NavActions) {

    Surface(modifier = Modifier.supportWideScreen()) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(
                modifier = Modifier
                    .weight(1f)
                    .animateContentSize()
            )
            Branding()
            Spacer(
                modifier = Modifier
                    .weight(1f)
                    .animateContentSize()
            )
            Button(
                onClick = navActions.goToSecondScreen,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(40.dp)
            ) {
                Text(
                    color = Color.White,
                    text = "Go To Second Screen",
                    style = MaterialTheme.typography.titleSmall
                )
            }
        }

    }
}

@Composable
private fun Logo(
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(id = R.drawable.logo),
        modifier = modifier,
        contentDescription = null
    )
}

@Composable
private fun Branding(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.wrapContentHeight(align = Alignment.CenterVertically)
    ) {
        Logo(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 76.dp)
        )
        Text(
            text = "This application is the start of something beautiful.",
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxWidth()
        )
    }
}

@DevicePreview
@Composable
fun WelcomeScreenPreview() {
    StartingPointTheme {
        FirstScreen(rememberNavController().navActions())
    }
}