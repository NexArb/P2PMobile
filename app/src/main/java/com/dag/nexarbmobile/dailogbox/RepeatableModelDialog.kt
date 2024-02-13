package com.dag.nexarbmobile.dailogbox

import com.dag.nexarbmobile.base.ui.base.NexarbViewState

interface RepeatableModelDialog: NexarbViewState, RepeatableViewEffect, ModelDialog {
    val repeatOnPositiveButtonClick:Boolean
    val repeatOnNegativeButtonClick:Boolean
    val repeatOnCancel:Boolean
}