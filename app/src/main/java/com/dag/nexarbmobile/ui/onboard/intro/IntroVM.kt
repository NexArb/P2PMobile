package com.dag.nexarbmobile.ui.onboard.intro

import com.dag.nexarbmobile.R
import com.dag.nexarbmobile.base.ui.base.NexarbViewModel
import com.dag.nexarbmobile.data.types.ButtonType
import com.dag.nexarbmobile.localdatastorage.preferencesdatastore.PreferencesDataStore
import com.dag.nexarbmobile.localdatastorage.preferencesdatastore.PreferencesDataStoreKeys
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class IntroVM @Inject constructor(
    var preferencesDataStore: PreferencesDataStore,
): NexarbViewModel() {

    private var currentState = 1;

    val FIRST_STATE = IntroVS.State(
        R.string.intro_screen_state1_title,
        R.string.intro_screen_state1_text,
        R.string.intro_screen_state_button_text,
        ButtonType.SecondaryButton
    )
    private val SECOND_STATE = IntroVS.State(
        R.string.intro_screen_state2_title,
        R.string.intro_screen_state2_text,
        R.string.intro_screen_state_button_text,
        ButtonType.SecondaryButton
    )
    private val THIRD_STATE = IntroVS.State(
        R.string.intro_screen_state3_title,
        R.string.intro_screen_state3_text,
        R.string.intro_screen_state_button_text,
        ButtonType.SecondaryButton
    )
    private val FORTH_STATE = IntroVS.State(
        R.string.intro_screen_state4_title,
        R.string.intro_screen_state4_text,
        R.string.intro_screen_state_button_last_text,
        ButtonType.PrimaryButton
    )

    suspend fun saveIntroFinished() {
        preferencesDataStore.write(PreferencesDataStoreKeys.FIRST_LOGIN,true)
        viewState.postValue(IntroVS.NavigateUserPage)
    }

    fun changeState() {
        currentState += 1;
        when(currentState) {
            2 -> viewState.postValue(SECOND_STATE)
            3 -> viewState.postValue(THIRD_STATE)
            4 -> viewState.postValue(FORTH_STATE)
            5 -> viewState.postValue(IntroVS.StateFinished)
        }
    }
}