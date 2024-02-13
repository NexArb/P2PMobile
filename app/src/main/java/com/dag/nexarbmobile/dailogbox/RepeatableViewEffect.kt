package com.dag.nexarbmobile.dailogbox

import com.dag.nexarbmobile.base.ui.base.NexarbViewState
import kotlinx.coroutines.suspendCancellableCoroutine

interface RepeatableViewEffect: NexarbViewState {
    var onRepeatAction:((Boolean)->Unit)?
}

suspend fun NexarbViewState.shouldRetry():Boolean = suspendCancellableCoroutine { cancellableContinuation ->
    if (this is RepeatableViewEffect){
        onRepeatAction = {
            cancellableContinuation.resume(it,{})
        }
    }else {
        cancellableContinuation.resume(false,{})
    }
}