package com.dag.nexarbmobile.ui.home.listings.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupProperties
import androidx.compose.ui.zIndex
import com.dag.nexarbmobile.R
import com.dag.nexarbmobile.composebase.button.CustomButton
import com.dag.nexarbmobile.data.types.ButtonType
import com.dag.nexarbmobile.ui.home.HomePreview

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CreatingListingBottomSheet() {
    var showModal by remember { mutableStateOf(false) }

    ModalBottomSheetLayout(
        sheetContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(fraction = 0.8f)
                    .clip(RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp))
                    .background(MaterialTheme.colors.background)
                    .padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight(fraction = 0.6f),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    CreatingListingDropdown()
                    CreatingListingTextField()
                    CreatingListingDropdown()
                    CreatingListingDropdown()
                }

                CustomButton(
                    buttonType = ButtonType.ColorfulButton,
                    onClick = {}
                ) {
                    Text(text = stringResource(id = R.string.add_listing_screen_add_button))
                }

            }
        },
        sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Expanded)
    ) { }
}

@Composable
fun CreatingListingTextField(){
    var amount by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        TextField(
            value = amount,
            onValueChange = { newAmount -> amount = newAmount },
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .padding(bottom = 8.dp)
                .border(1.dp,Color.White, CircleShape), // Space before the "Minimum: 10 USD" Text
            label = {
                Text("Amount", color = Color.White)
            },
            trailingIcon = {
                Box(
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .background(
                            Color(0xFF00C853),
                            shape = RoundedCornerShape(50)
                        ),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Text(
                        text = "USD",
                        color = Color.White,
                        modifier = Modifier.padding(
                            horizontal = 16.dp,
                            vertical = 8.dp
                        )
                    )
                }
            }
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        ) {
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Minimum: 10 USD",
                color = Color.Gray,
                fontSize = 12.sp
            )
        }
    }

}

@Composable
fun CreatingListingDropdown() {
    var expanded by remember { mutableStateOf(false) }
    val items = listOf("Credit Card", "PayPal", "Bank Transfer", "Cash on Delivery")
    var selectedIndex by remember { mutableStateOf(0) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.White, CircleShape)
            .clickable { expanded = true },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Payment Method",
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.background),
            properties = PopupProperties()
        ) {
            items.forEachIndexed { index, title ->
                DropdownMenuItem(onClick = {
                    selectedIndex = index
                    expanded = false
                }) {
                    Text(text = title)
                }
            }
        }
        Icon(
            painter = if (!expanded)
                painterResource(id = R.drawable.arrow_downward)
            else painterResource(id = R.drawable.arrow_upward),
            contentDescription = "arrow",
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(16.dp),
            tint = Color.White
        )
    }
}

@Preview
@Composable
fun CreatingListingBottomSheetPreview() {
    HomePreview {
        CreatingListingBottomSheet()
    }
}