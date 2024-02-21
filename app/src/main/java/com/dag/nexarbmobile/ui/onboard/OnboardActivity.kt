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
import com.dag.nexarbmobile.composebase.navcontroller.NavGraph
import com.dag.nexarbmobile.composebase.navcontroller.NavScreen
import com.dag.nexarbmobile.localdatastorage.preferencesdatastore.PreferencesDataStore
import com.dag.nexarbmobile.localdatastorage.preferencesdatastore.PreferencesDataStoreKeys
import com.dag.nexarbmobile.ui.theme.NexArbMobileTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnboardActivity : ComponentActivity() {

    @Inject
    lateinit var preferencesDataStore: PreferencesDataStore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NexArbMobileTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NavGraph(
                        startDestination = NavScreen.WelcomeScreen.route,
                        isOnboard = true,
                        preferencesDataStore = preferencesDataStore
                    )
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