package com.dag.nexarbmobile.network.interceptors

import android.content.Context
import com.dag.nexarbmobile.base.ext.isNetworkStatusAvailable
import com.dag.nexarbmobile.network.NetworkConnectionFailure
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class NetworkConnectionInterceptor @Inject constructor(
    @ApplicationContext private val context: Context
) : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        if (context.isNetworkStatusAvailable()){
            throw NetworkConnectionFailure
        }
        return chain.proceed(chain.request())
    }
}