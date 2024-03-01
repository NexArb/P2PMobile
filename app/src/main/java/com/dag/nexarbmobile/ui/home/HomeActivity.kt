package com.dag.nexarbmobile.ui.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.dag.nexarbmobile.composebase.navcontroller.NavGraph
import com.dag.nexarbmobile.composebase.navcontroller.NavScreen
import com.dag.nexarbmobile.localdatastorage.preferencesdatastore.PreferencesDataStore
import com.dag.nexarbmobile.ui.onboard.OnboardSurface
import com.dag.nexarbmobile.ui.theme.NexArbMobileTheme
import com.solana.mobilewalletadapter.clientlib.ActivityResultSender
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityResultSender = ActivityResultSender(this)
        setContent {
            NexArbMobileTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NavGraph(
                        startDestination = NavScreen.HomeScreen.route,
                        isOnboard = false,
                        activityResulSender =activityResultSender
                    )
                }
            }
        }
    }
}

@Composable
fun HomeSurface(
    backgroundColor: Color = MaterialTheme.colors.background,
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
fun HomePreview(content: @Composable () -> Unit){
    HomeSurface {
        content()
    }
}