package com.dag.nexarbmobile.ui.onboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.dag.nexarbmobile.ui.theme.NexArbMobileTheme

class OnboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NexArbMobileTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}

@Composable
fun OnboardSurface(
    backgroundColor: Color = Color.White,
    content:@Composable ()->Unit
) {
    NexArbMobileTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = backgroundColor
        ){
            content()
        }
    }
}

@Composable
fun OnboardPreview(content: @Composable () -> Unit){
    OnboardSurface {
        content()
    }
}