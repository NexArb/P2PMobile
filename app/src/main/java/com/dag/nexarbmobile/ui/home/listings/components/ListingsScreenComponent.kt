package com.dag.nexarbmobile.ui.home.listings.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dag.nexarbmobile.R
import com.dag.nexarbmobile.composebase.Drawer
import com.dag.nexarbmobile.composebase.button.CustomButton
import com.dag.nexarbmobile.data.types.ButtonType
import com.dag.nexarbmobile.ui.home.HomePreview
import com.dag.nexarbmobile.ui.home.listings.data.ListingsRowData
import com.dag.nexarbmobile.ui.home.listings.data.OfferButtonsType
import com.dag.nexarbmobile.ui.theme.Primary
import com.dag.nexarbmobile.ui.theme.Secondary

@Composable
fun ListingRow(
    modifier: Modifier,
    data: ListingsRowData,
    height: Dp
) {
    var offerBarExpanded by remember { mutableStateOf(false) }
    Column {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(height)
                .padding(bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.3f)
                    .height(height),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.height(height/2),
                    text = data.ownerUsername,
                    style = MaterialTheme.typography.body2
                )
                ListingRowStar(currentRatio = data.ownerCommentPoint)
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.5f)
                    .height(height),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.height(height/2),
                    text = "${data.price} ${data.currency}",
                    style = MaterialTheme.typography.body2
                )
                Text(
                    text = "Conversion",
                    style = MaterialTheme.typography.body2
                )
            }
            IconButton(
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.4f)
                    .height(height),
                onClick = {
                    offerBarExpanded = !offerBarExpanded
                }
            ) {
                Icon(
                    modifier = Modifier
                        .height(height / 2),
                    painter = painterResource(id = R.drawable.more),
                    contentDescription = "More",
                    tint = Color.White
                )
            }
        }
        if (!offerBarExpanded) {
            Spacer(modifier = modifier.height(4.dp))
            Drawer()
        }else{
            OfferButtons(onClick = {})
        }

    }

}

@Composable
fun OfferButtons(
    onClick: (buttonType: OfferButtonsType) -> Unit
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .background(Primary)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ){
        CustomButton(
            onClick = {
                onClick(OfferButtonsType.Buy)
            },
            buttonType = ButtonType.SecondaryButton,
            modifier = Modifier.width(150.dp)
        ) {
            Text(
                text = stringResource(id = R.string.listing_screen_buy_button_text),
                style = MaterialTheme.typography.body1
            )
        }
        CustomButton(
            onClick = {
                onClick(OfferButtonsType.Offer)
            },
            modifier = Modifier.width(150.dp)
        ) {
            Text(
                text = stringResource(id = R.string.listing_screen_offer_button_text),
                style = MaterialTheme.typography.body1
            )
        }
    }
}

@Composable
fun ListingRowStar(currentRatio: Int = -1) {
    val maxStar = 5
    var selectedButtonState by remember { mutableIntStateOf(currentRatio) }
    LazyRow(
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentWidth(),
        contentPadding = PaddingValues(0.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(maxStar) {

            Icon(
                modifier = Modifier
                    .padding(
                        start = if (it != 0) 5.dp else 0.dp,
                        end = 5.dp,
                        top = 5.dp
                    )
                    .fillMaxHeight()
                    .clickable {
                        selectedButtonState = it
                    },
                painter = painterResource(id = R.drawable.star),
                tint = if (it <= selectedButtonState) Secondary else Color.Gray,
                contentDescription = "Star $it"
            )
        }

    }
}


@Composable
@Preview
fun OfferButtonsReview() {
    HomePreview {
        OfferButtons {

        }
    }
}

@Composable
@Preview
fun ListingRowStarPreview() {
    HomePreview {
        ListingRowStar()
    }
}

@Composable
@Preview
fun ListingsRowPreview() {
    HomePreview {
        ListingRow(
            modifier = Modifier
                .background(Color.Black),
            data = ListingsRowData(
                "Dogukan",
                4,
                5312.4f,
                "SOL"
            ),
            height = 50.dp
        )
    }

}