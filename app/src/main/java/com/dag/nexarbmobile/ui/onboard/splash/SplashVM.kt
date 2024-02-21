package com.dag.nexarbmobile.ui.onboard.splash

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import com.dag.nexarbmobile.base.ui.base.NexarbViewModel
import com.dag.nexarbmobile.composebase.navcontroller.NavScreen
import com.dag.nexarbmobile.localdatastorage.preferencesdatastore.PreferencesDataStore
import com.dag.nexarbmobile.localdatastorage.preferencesdatastore.PreferencesDataStoreKeys
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.cancellable
import kotlinx.coroutines.flow.dropWhile
import kotlinx.coroutines.flow.takeWhile
import javax.inject.Inject

@HiltViewModel
class SplashVM @Inject constructor(
    var preferencesDataStore: PreferencesDataStore,
): NexarbViewModel() {

    init {
        viewState.postValue(SplashVS.Loading)
    }

    fun done(){
        viewState.postValue(SplashVS.Done)
    }

    suspend fun readLoginState(navHostController: NavHostController){
        preferencesDataStore.read(PreferencesDataStoreKeys.FIRST_LOGIN)
            .takeWhile { viewState.value != SplashVS.Done }
            .collect{
                if (it == true){
                    navHostController.navigate(NavScreen.LoginScreen.route)
                    viewState.postValue(SplashVS.GoToUserOpScreen)
                }else {
                    navHostController.navigate(NavScreen.IntroScreen.route)
                    viewState.postValue(SplashVS.GoToIntroScreen)
                }
            }
    }

}