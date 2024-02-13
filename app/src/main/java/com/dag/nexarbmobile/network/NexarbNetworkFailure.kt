package com.dag.nexarbmobile.network

import com.dag.nexarbmobile.dailogbox.DialogBoxModel
import retrofit2.Response
import java.io.IOException

sealed class NexarbNetworkFailure : IOException()

object NetworkConnectionFailure : NexarbNetworkFailure()

object UnauthenticatedFailure : NexarbNetworkFailure()

object SocketTimeoutFailure : NexarbNetworkFailure()

data class ApiFailure(val response: Response<*>) : NexarbNetworkFailure()

data class DialogFailure(val dialogBox: DialogBoxModel?):NexarbNetworkFailure()

data class UnexpectedFailure(val throwable: Throwable) : NexarbNetworkFailure()
