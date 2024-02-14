package com.dag.nexarbmobile.composebase.appbar

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dag.nexarbmobile.R
import com.dag.nexarbmobile.composebase.NexarbPreview


@Composable
fun CustomAppbar() {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.h1.copy(color = Color.Black)
                )
            }
        },
        navigationIcon = {
            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
            ) {

            }
        },
        backgroundColor = Color.White,
        actions = {
            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
            ) {

            }
        }
    )
}

@Composable
@Preview
fun CustomAppbarPreview() {
    NexarbPreview {
        CustomAppbar()
    }
}