package com.dag.nexarbmobile.ui.home.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dag.nexarbmobile.ui.home.HomePreview

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
                .background(Color.Gray.copy(alpha = 0.9f))
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