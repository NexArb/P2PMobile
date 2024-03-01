package com.dag.nexarbmobile.ui.home.homescreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dag.nexarbmobile.ui.home.HomePreview
import com.dag.nexarbmobile.ui.home.HomeSurface

@Composable
fun HomeScreen(){
    HomeSurface {
        Column(
            modifier = Modifier
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HomeBalanceHeader(balance = "\$2,610.50")
        }
    }
}


@Preview
@Composable
fun HomeScreenPreview(){
    HomePreview {
        HomeScreen()
    }
}