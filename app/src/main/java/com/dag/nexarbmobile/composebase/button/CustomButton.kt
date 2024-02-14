package com.dag.nexarbmobile.composebase.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
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
    border: BorderStroke = BorderStroke(1.dp, color),
    onClick: () -> Unit,
    buttonType: ButtonType = ButtonType.PrimaryButton,
    content: @Composable RowScope.() -> Unit
){
    var boxModifier = Modifier.padding().clip(RoundedCornerShape(32.dp))
    if (buttonType == ButtonType.ColorfulButton) {
        boxModifier = boxModifier.background(ColorfulButtonBackground)
    }

    Box(
        modifier = boxModifier,
    ) {
        CustomButtonInside(
            modifier = modifier,
            color = color,
            border = border,
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
        border = if (buttonType == ButtonType.PrimaryButton) border else BorderStroke(0.dp,Color.Transparent),
        colors = ButtonDefaults.buttonColors(backgroundColor =
        if(buttonType == ButtonType.ColorfulButton) Color.Transparent else color),
        elevation = ButtonDefaults.elevation(0.dp),
        shape = RoundedCornerShape(7.dp)
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
            border = BorderStroke(1.dp, Color.Black)
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
            border = BorderStroke(1.dp, Color.Transparent)
        ) {
            Text(
                text = "Get Started",
                color = Color.White
            )
        }
    }
}