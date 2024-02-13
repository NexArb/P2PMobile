package com.dag.nexarbmobile.network

import android.os.Parcelable
import com.dag.nexarbmobile.dailogbox.DialogBoxModel
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
open class BaseResponse:Parcelable {
    @SerializedName("dialogBoxDto")
    var dialogBox: DialogBoxModel? = null
    var error:Boolean = false
    val isFailure get() = error
}