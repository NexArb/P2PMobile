package com.dag.nexarbmobile.data.userop

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserLogin(
    var phoneNumber:String = "",
    var password:String = ""
):Parcelable
