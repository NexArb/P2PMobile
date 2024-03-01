package com.dag.nexarbmobile.ui.onboard.userop.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dag.nexarbmobile.R
import com.dag.nexarbmobile.composebase.NexarbPreview
import com.dag.nexarbmobile.composebase.button.CustomButton
import com.dag.nexarbmobile.composebase.textbox.NexarbTextbox
import com.dag.nexarbmobile.data.types.ButtonType
import com.dag.nexarbmobile.ui.onboard.userop.components.UserOpWrapper
import com.dag.nexarbmobile.ui.onboard.userop.register.RegisterVM


@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: RegisterVM = viewModel()
) {

    UserOpWrapper {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                .background(MaterialTheme.colors.primary)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                NexarbTextbox(
                    modifier = Modifier.padding(top = 32.dp),
                    placeholder = R.string.login_screen_email_placeholder,
                    onValueChange = {

                    }
                )
                Column(horizontalAlignment = Alignment.End) {
                    NexarbTextbox(
                        modifier = Modifier.padding(top = 16.dp),
                        placeholder = R.string.login_screen_password_placeholder,
                        onValueChange = {

                        }
                    )
                    TextButton(onClick = {}) {
                        Text(
                            text = stringResource(id = R.string.login_screen_forgot_password),
                            style = MaterialTheme.typography.body2.copy(color = MaterialTheme.colors.secondary),
                            textAlign = TextAlign.End
                        )
                    }
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                CustomButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 64.dp),
                    buttonType = ButtonType.PrimaryButton,
                    onClick = {
                    }
                ) {
                    Text(stringResource(id = R.string.login_screen_button_text))
                }
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    stringResource(id = R.string.login_screen_link_to_register),
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .clickable {
                        },
                )
            }

        }
    }
}


@Composable
@Preview
fun UserOpScreenPreview() {
    NexarbPreview {
        LoginScreen(
            navController = rememberNavController()
        )
    }
}
