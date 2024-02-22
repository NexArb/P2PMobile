package com.dag.nexarbmobile.ui.onboard.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.dag.nexarbmobile.R
import com.dag.nexarbmobile.base.ui.base.NexarbViewState
import com.dag.nexarbmobile.composebase.button.CustomButton
import com.dag.nexarbmobile.composebase.navcontroller.NavScreen
import com.dag.nexarbmobile.data.types.ButtonType
import com.dag.nexarbmobile.localdatastorage.preferencesdatastore.PreferencesDataStoreKeys
import com.dag.nexarbmobile.ui.onboard.OnboardPreview
import com.dag.nexarbmobile.ui.onboard.OnboardSurface

@Composable
fun SplashScreen(
    navController: NavHostController,
    viewModel: SplashVM = viewModel()
) {
    val userState by viewModel.viewState.observeAsState()
    LaunchedEffect("read_user_state"){
        viewModel.readLoginState(navController)
    }
    OnboardSurface(modifier = Modifier) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ){
            Image(
                painter = painterResource(id = R.drawable.background),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxSize()
            ) {
                Spacer(modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth())
                Image(
                    ImageBitmap.imageResource(id = R.drawable.nexarblogo),
                    contentDescription = "",
                    modifier = Modifier
                        .padding()
                        .fillMaxWidth()
                        .height(40.dp)
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(horizontal = 32.dp, vertical = 64.dp)
                ) {
                    if (userState == SplashVS.Loading){
                        CustomButton(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 64.dp),
                            buttonType = ButtonType.ColorfulButton,
                            onClick = {
                                navController.navigate(NavScreen.LoginScreen.route)
                            }
                        ) {
                            Text(stringResource(id = R.string.splash_screen_button))
                        }
                        Spacer(modifier = Modifier.size(16.dp))
                        Text(
                            stringResource(id=R.string.splash_screen_message),
                            modifier = Modifier.clickable {
                                navController.navigate(NavScreen.RegisterScreen.route)
                            },
                        )
                    }
                }

            }

        }

    }
}


@Composable
@Preview
fun SplashScreenView() {
    OnboardPreview {
        SplashScreen(
            rememberNavController(),
        )
    }
}