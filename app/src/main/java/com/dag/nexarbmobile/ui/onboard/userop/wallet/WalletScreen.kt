package com.dag.nexarbmobile.ui.onboard.userop.wallet

import android.content.Context
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCompositionContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dag.nexarbmobile.R
import com.dag.nexarbmobile.base.NexarbActivityListener
import com.dag.nexarbmobile.base.NexarbApplication
import com.dag.nexarbmobile.composebase.NexarbPreview
import com.dag.nexarbmobile.composebase.button.CustomButton
import com.dag.nexarbmobile.data.types.ButtonType
import com.dag.nexarbmobile.ui.onboard.OnboardSurface
import com.dag.nexarbmobile.ui.onboard.userop.components.UserOpWrapper
import com.dag.nexarbmobile.ui.theme.PhantomWalletColor
import com.solana.mobilewalletadapter.clientlib.ActivityResultSender

@Composable
fun WalletScreen(
    navController: NavController,
    viewModel: WalletVM = viewModel(),
    activityResultSender: ActivityResultSender? = null
) {
    UserOpWrapper {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                .background(MaterialTheme.colors.primary)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )  {
            CustomButton(
                buttonType = ButtonType.Custom,
                color = PhantomWalletColor,
                onClick = {
                    activityResultSender?.let {
                        viewModel.connect(it)
                    }
                }
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(id = R.string.wallet_connect_text),
                        style = MaterialTheme.typography.h5.copy(
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Image(
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .size(32.dp),
                        painter = painterResource(id = R.drawable.phantom_logo),
                        contentDescription = "Phantom-Wallet"
                    )
                }

            }
        }
    }

}

@Composable
@Preview
fun WalletScreenPreview() {
    NexarbPreview {
        WalletScreen(
            rememberNavController(),
        )
    }
}