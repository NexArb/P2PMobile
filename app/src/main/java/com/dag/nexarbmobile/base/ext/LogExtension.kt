package com.dag.nexarbmobile.base.ext

import android.util.Log
import com.dag.nexarbmobile.base.ext.tryCatch

inline val <reified T> T.TAG:String get() = T::class.java.name

inline fun <reified T> T.logDebug(message:Any?,logTag:String = "LogDebug ${this.TAG}",isError:Boolean = false){
    tryCatch(
        {
            if (isError) Log.e(logTag,"$message") else Log.d(logTag,"$message")
        }
    )
}