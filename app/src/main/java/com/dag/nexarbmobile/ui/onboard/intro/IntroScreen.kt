package com.dag.nexarbmobile.ui.onboard.intro

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dag.nexarbmobile.R
import com.dag.nexarbmobile.composebase.NexarbPreview
import com.dag.nexarbmobile.composebase.button.CustomButton
import com.dag.nexarbmobile.data.types.ButtonType

@Composable
fun IntroScreen(
    navController: NavController,
    viewModel: IntroVM = viewModel()
) {
    // Background
    Image(
        painter = BitmapPainter(image = ImageBitmap.imageResource(id = R.drawable.intro_backgorund)),
        contentDescription = null, // Optional content description for accessibility
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds // Adjust content scale as needed
    )
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IntroScreenHeader()
        IntroScreenTitle(title = R.drawable.intro1)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.9f)
                .background(color = MaterialTheme.colors.primary)
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(fraction = 0.5f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "Title",
                    style = MaterialTheme.typography.h1
                )
                Text(
                    text = "Caption",
                    style = MaterialTheme.typography.caption
                )
            }
            CustomButton(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 64.dp),
                color = MaterialTheme.colors.primary,
                border = BorderStroke(2.dp, MaterialTheme.colors.secondary),
                buttonType = ButtonType.SecondaryButton,
                onClick = {}
            ) {
                Text(
                    text = "Next Step",
                    style = MaterialTheme.typography.body2.copy(color = MaterialTheme.colors.secondary)
                )
            }
        }
    }
}

@Composable
private fun IntroScreenTitle(
    title: Int
) {
    Row {
        Image(
            painter = BitmapPainter(image = ImageBitmap.imageResource(id = title)),
            contentDescription = "Title",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.4f)
                .padding(horizontal = 32.dp)
        )
    }
}

@Composable
private fun IntroScreenHeader() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        TextButton(onClick = {}) {
            Text(
                text = stringResource(id = R.string.intro_screen_skip_button),
                style = MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.secondary)
            )
        }
    }
}


@Composable
@Preview
fun IntroScreenPreview() {
    NexarbPreview {
        IntroScreen(navController = rememberNavController())
    }
}