package com.dag.nexarbmobile.ui.onboard.intro

import com.dag.nexarbmobile.base.ui.base.NexarbViewState
import com.dag.nexarbmobile.data.types.ButtonType

sealed class IntroVS : NexarbViewState {
    class State(val title: Int, val subtext: Int, val buttonText: Int, val buttonType:ButtonType) : NexarbViewState
    object StateFinished : NexarbViewState
}