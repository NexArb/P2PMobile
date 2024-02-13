package com.dag.nexarbmobile.base.ext

import com.dag.nexarbmobile.base.ui.base.NexarbViewState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.suspendCancellableCoroutine

interface RepeatableRentViewEffect : NexarbViewState {

    var onRepeatAction: ((Boolean) -> Unit)?
}

@OptIn(ExperimentalCoroutinesApi::class)
suspend fun NexarbViewState.shouldRetry(): Boolean = suspendCancellableCoroutine { continuation ->
    if (this is RepeatableRentViewEffect) {
        onRepeatAction = {
            continuation.resume(it,null)
        }
    } else {
        continuation.resume(false,null)
    }
}