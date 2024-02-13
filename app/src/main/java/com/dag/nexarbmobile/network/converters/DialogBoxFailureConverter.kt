package com.dag.nexarbmobile.network.converters

import com.dag.nexarbmobile.network.BaseResponse
import com.dag.nexarbmobile.network.DialogFailure
import com.dag.nexarbmobile.dailogbox.DialogBoxType
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

class DialogBoxFailureConverter : Converter.Factory() {
    override fun responseBodyConverter(
        type: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<ResponseBody, *>? {
        val delegate: Converter<ResponseBody, Any> =
            retrofit.nextResponseBodyConverter(this, type, annotations)
        return Converter<ResponseBody, Any> {
            val t = delegate.convert(it)
            if (t is BaseResponse && t.dialogBox?.type == DialogBoxType.BLOCKER) {
                throw DialogFailure(t.dialogBox)
            } else {
                return@Converter t
            }
        }
    }
}