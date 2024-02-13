package com.dag.nexarbmobile.errorhandling

import com.dag.nexarbmobile.base.ui.base.NexarbViewState


interface ErrorHandler {

    fun handle(throwable: Throwable): NexarbViewState?
}