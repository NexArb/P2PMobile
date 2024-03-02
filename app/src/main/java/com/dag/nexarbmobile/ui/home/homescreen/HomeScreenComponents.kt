package com.dag.nexarbmobile.ui.home.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.dag.nexarbmobile.ui.home.HomePreview
import com.dag.nexarbmobile.ui.home.data.HomeScreenBalanceChartData
import org.eazegraph.lib.charts.PieChart
import org.eazegraph.lib.models.PieModel


@Composable
fun HomeScreenTransactionCard() {
    Box(
        modifier = Modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.Gray.copy(alpha = 0.25f))
                .padding(all = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Bought SOL",
                    style = MaterialTheme.typography.body2
                )
                Text(
                    text = "+0.65 SOL",
                    style = MaterialTheme.typography.body2
                )
            }
            Column {
                Text(
                    text = "-\$812.10",
                    style = MaterialTheme
                        .typography
                        .body2
                        .copy(color=Color.White.copy(alpha = 0.7f))
                )
                Text(
                    text = "30 Jan 2024, 3.30 PM",
                    style = MaterialTheme
                        .typography
                        .body2
                        .copy(color=Color.White.copy(alpha = 0.7f))
                )
            }

        }
    }
}

@Composable
@Preview
fun HomeScreenTransactionCardPreview() {
    HomePreview {
        HomeScreenTransactionCard()
    }
}

@Composable
fun HomeScreenBalanceGraph(
    modifier:Modifier = Modifier,
    data:HomeScreenBalanceChartData
){
    Box(
        modifier = modifier
            .padding(
                horizontal = 32.dp,
                vertical = 16.dp
            )
    ) {
        AndroidView(factory = { context->
            val pieChart = PieChart(context)
            pieChart.clearChart()
            pieChart.addPieSlice(
                PieModel(
                    "Income",
                    data.income.toFloat(),
                    android.graphics.Color.parseColor("#29005D")
                ))
            pieChart.addPieSlice(
                PieModel(
                    "Outgoings",
                    data.outgoings.toFloat(),
                    android.graphics.Color.parseColor("#12056A")
                ))
            pieChart.isUseCustomInnerValue = true
            pieChart.innerValueString = "Solana Balance: ${(data.income-data.outgoings)}"
            pieChart.valueTextColor = 0xFFFFFFFF.toInt()
            pieChart.innerPadding = 80f
            pieChart.innerPaddingColor = android.graphics.Color.parseColor("#06012E")
            pieChart.legendHeight = 0f
            pieChart
        })
    }

}


@Composable
@Preview
fun HomeScreenBalanceGraphPreview(){
    HomePreview {
        HomeScreenBalanceGraph(
            Modifier,
            HomeScreenBalanceChartData(30,20)
        )
    }
}

@Composable
fun HomeBalanceHeader(balance:String){
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Your Balance",
            style = MaterialTheme.typography.h4
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = balance,
            style = MaterialTheme.typography.h2.copy(fontWeight = FontWeight.Bold)
        )
    }
}

@Composable
@Preview
fun HomeBalanceHeaderPreview(){
    HomePreview {
        HomeBalanceHeader(balance = "\$2,610.50")
    }
}