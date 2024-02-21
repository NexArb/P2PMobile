package com.dag.nexarbmobile.ui.onboard.splash

import com.dag.nexarbmobile.base.ui.base.NexarbViewState

sealed class SplashVS : NexarbViewState {
    object GoToIntroScreen: SplashVS()
    object GoToUserOpScreen: SplashVS()
    object Loading: SplashVS()
    object Done : SplashVS()
}