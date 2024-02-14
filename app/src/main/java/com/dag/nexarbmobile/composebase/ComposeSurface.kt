package com.dag.nexarbmobile.composebase

import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.dag.nexarbmobile.composebase.appbar.CustomAppbar
import com.dag.nexarbmobile.ui.theme.NexArbMobileTheme


@Composable
fun NexarbSurface(
    appbar: @Composable () -> Unit,
    bottomBar: @Composable () -> Unit,
    backgroundColor: Color,
    content: @Composable () -> Unit
) {

    Scaffold(
        topBar = appbar,
        bottomBar = bottomBar,
        backgroundColor = backgroundColor
    ) {
        Surface {
            content()
        }
    }

}

@Composable
fun NexarbPreview(content: @Composable () -> Unit){
    NexArbMobileTheme() {
        content()
    }
}

@Preview
@Composable
fun NexarbSurfacePreview() {
    NexarbSurface(
        appbar = {
            CustomAppbar()
        },
        bottomBar = {
        },
        backgroundColor = Color.LightGray
    ) {
        Text(text = "Deneme")
    }
}