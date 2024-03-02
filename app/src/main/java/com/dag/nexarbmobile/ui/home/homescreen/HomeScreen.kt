package com.dag.nexarbmobile.ui.home.homescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dag.nexarbmobile.R
import com.dag.nexarbmobile.ui.home.HomePreview
import com.dag.nexarbmobile.ui.home.HomeSurface
import com.dag.nexarbmobile.ui.home.data.HomeScreenBalanceChartData
import com.dag.nexarbmobile.ui.theme.CustomButtonInnerColor
import com.dag.nexarbmobile.ui.theme.Primary

@Composable
fun HomeScreen(){
    HomeSurface {
        Column(
            modifier = Modifier
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HomeBalanceHeader(balance = "\$2,610.50")
            HomeScreenBalanceGraph(
                modifier = Modifier
                    .fillMaxHeight(fraction = 0.7f),
                data = HomeScreenBalanceChartData(10, 20)
            )
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        modifier = Modifier,
                        text = stringResource(id = R.string.home_screen_transaction_title),
                        style = MaterialTheme.typography.h6
                    )
                    TextButton(onClick = {

                    }) {
                        Text(
                            text = stringResource(id = R.string.see_more),
                            style = MaterialTheme.typography.body2.copy(color = CustomButtonInnerColor)
                        )
                    }
                }
                HomeScreenTransactionCard()
            }
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