package com.dag.nexarbmobile.ui.onboard.userop.wallet

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dag.nexarbmobile.composebase.NexarbPreview
import com.dag.nexarbmobile.ui.onboard.OnboardSurface
import com.dag.nexarbmobile.ui.onboard.userop.components.UserOpWrapper

@Composable
fun WalletScreen(
    navController: NavController,
    viewModel: WalletVM = viewModel()
){
    OnboardSurface(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        UserOpWrapper {

        }
    }
}

@Composable
@Preview
fun WalletScreenPreview(){
    NexarbPreview {
        WalletScreen(
            rememberNavController()
        )
    }
}