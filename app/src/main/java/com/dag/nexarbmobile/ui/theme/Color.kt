package com.dag.nexarbmobile.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val ButtonColor = Color(0xFFF3B007)
val HomeListRowButtonColor = Color(0xFFFA6909)
val UnSelectedBottomItem = Color(0xFF929292)
val BackgroundColor = Color(0xFF12056A)
val BackgroundColorVariant1 = Color(0xFF020A07)
val BackgroundColorVariant2 = Color(0xFF06012E)
val Primary = Color(0xFF29005D)
val Secondary = Color(0xFF14E4A6)
val CustomButtonInnerColor = Color(0xFF6D558F)
val CustomButtonInnerSelectedColor = Color(0xFFD3D3D3).copy(alpha = 0.5f)
private val ButtonColorVariant1 = Color(0xFF10E9A2)
private val ButtonColorVariant2 = Color(0xFF429FD6)
private val ButtonColorVariant3 = Color(0xFF9749FB)
val PhantomWalletColor = Color(0xFF9786EA)

val Background = Brush.horizontalGradient(
    colors = listOf(
        BackgroundColor,
        BackgroundColorVariant1,
        BackgroundColorVariant2
    ),
    startX = 10f
)

val ColorfulButtonBackground = Brush.horizontalGradient(
    colors = listOf(
        ButtonColorVariant3,
        ButtonColorVariant1,
        ButtonColorVariant2,
    ),
    startX = 10f
)