package com.dag.nexarbmobile.errorhandling


import com.dag.nexarbmobile.R
import com.dag.nexarbmobile.base.ui.base.NexarbViewState
import com.dag.nexarbmobile.dailogbox.createGenericDialog
import com.dag.nexarbmobile.dailogbox.createRepeatableDialog
import com.dag.nexarbmobile.network.*
import java.net.HttpURLConnection
import javax.inject.Inject

open class DefaultErrorHandler @Inject constructor() : ErrorHandler {

    override fun handle(throwable: Throwable): NexarbViewState? {
        if (throwable !is NexarbNetworkFailure) {
            return null
        }

        return when (throwable) {
            NetworkConnectionFailure -> networkConnectionDialog()
            UnauthenticatedFailure -> networkConnectionDialog()
            SocketTimeoutFailure, is UnexpectedFailure -> createGenericDialog()
            is ApiFailure -> {
                if (throwable.response.code() == HttpURLConnection.HTTP_GATEWAY_TIMEOUT) {
                    createRepeatableDialog()
                } else {
                    networkConnectionDialog()
                }
            }
            else -> {null}
        }
    }
}

// TODO: Hata mesajları gösterilcek

fun networkConnectionDialog(): NexarbViewState = createGenericDialog(
    titleRes = R.string.network_error_message_title,
    messageRes = R.string.network_error_message_text,
)