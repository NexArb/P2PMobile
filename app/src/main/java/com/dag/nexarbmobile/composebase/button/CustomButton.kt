package com.dag.nexarbmobile.composebase.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dag.nexarbmobile.data.types.ButtonType
import com.dag.nexarbmobile.ui.theme.ColorfulButtonBackground
import com.dag.nexarbmobile.ui.theme.NexArbMobileTheme


@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.secondary,
    onClick: () -> Unit,
    buttonType: ButtonType = ButtonType.PrimaryButton,
    content: @Composable RowScope.() -> Unit
){
    var boxModifier = Modifier.padding().clip(RoundedCornerShape(32.dp))
    if (buttonType == ButtonType.ColorfulButton) {
        boxModifier = boxModifier.background(ColorfulButtonBackground)
    }
    val buttonColor:Color = if (buttonType == ButtonType.PrimaryButton) MaterialTheme.colors.secondary
    else if (buttonType == ButtonType.SecondaryButton) Color.Transparent else color
    val buttonBorder:Color = if (buttonType == ButtonType.PrimaryButton) Color.Transparent
    else if (buttonType == ButtonType.SecondaryButton) MaterialTheme.colors.secondary else color
    Box(
        modifier = boxModifier,
    ) {
        CustomButtonInside(
            modifier = modifier,
            color = buttonColor,
            border = BorderStroke(1.dp, buttonBorder),
            onClick = onClick,
            content = content ,
            buttonType = buttonType
        )
    }

}

@Composable
private fun CustomButtonInside(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.secondary,
    border: BorderStroke = BorderStroke(1.dp, color),
    onClick: () -> Unit,
    buttonType: ButtonType = ButtonType.PrimaryButton,
    content: @Composable RowScope.() -> Unit
){
    Button(
        modifier = modifier,
        onClick = onClick,
        border = if (buttonType == ButtonType.ColorfulButton) BorderStroke(0.dp,Color.Transparent) else border  ,
        colors = ButtonDefaults.buttonColors(backgroundColor =
        if(buttonType == ButtonType.ColorfulButton) Color.Transparent else color),
        elevation = ButtonDefaults.elevation(0.dp),
        shape = RoundedCornerShape(32.dp)
    ) {
        content()
    }
}

@Composable
@Preview
fun CustomButtonPreview(){
    NexArbMobileTheme {
        CustomButton(
            onClick = {},
            color = MaterialTheme.colors.secondary,
        ) {
            Text(
                text = "Get Started",
                color = Color.White
            )
        }
    }
}

@Composable
@Preview
fun CustomSecondaryButtonPreview(){
    NexArbMobileTheme {
        CustomButton(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 64.dp),
            onClick = {},
            buttonType = ButtonType.SecondaryButton,
            color = Color.Transparent,
        ) {
            Text(
                text = "Get Started",
                color = Color.White
            )
        }
    }
}

@Composable
@Preview
fun CustomButtonColorfulPreview(){
    NexArbMobileTheme {
        CustomButton(
            onClick = {},
            color = MaterialTheme.colors.secondary,
            buttonType = ButtonType.ColorfulButton,
        ) {
            Text(
                text = "Get Started",
                color = Color.White
            )
        }
    }
}