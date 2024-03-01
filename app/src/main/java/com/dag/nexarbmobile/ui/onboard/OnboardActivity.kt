package com.dag.nexarbmobile.ui.onboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.dag.nexarbmobile.base.NexarbActivityListener
import com.dag.nexarbmobile.base.NexarbApplication
import com.dag.nexarbmobile.composebase.navcontroller.NavGraph
import com.dag.nexarbmobile.composebase.navcontroller.NavScreen
import com.dag.nexarbmobile.localdatastorage.preferencesdatastore.PreferencesDataStore
import com.dag.nexarbmobile.localdatastorage.preferencesdatastore.PreferencesDataStoreKeys
import com.dag.nexarbmobile.ui.theme.NexArbMobileTheme
import com.solana.mobilewalletadapter.clientlib.ActivityResultSender
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnboardActivity : ComponentActivity() {

    @Inject
    lateinit var preferencesDataStore: PreferencesDataStore

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
                        startDestination = NavScreen.WalletScreen.route,
                        isOnboard = true,
                        activityResulSender =activityResultSender
                    )
                }
            }
        }
    }
}

@Composable
fun OnboardSurface(
    backgroundColor: Color = Color.White,
    background: Brush? = null,
    modifier: Modifier,
    content:@Composable ()->Unit
) {
    var internalModifier = modifier.fillMaxSize()
    background?.let {
        internalModifier = modifier.background(it)
    }
    NexArbMobileTheme {
        Surface(
            modifier = internalModifier,
            color = backgroundColor
        ){
            content()
        }
    }
}

@Composable
fun OnboardPreview(content: @Composable () -> Unit){
    OnboardSurface(modifier = Modifier) {
        content()
    }
}