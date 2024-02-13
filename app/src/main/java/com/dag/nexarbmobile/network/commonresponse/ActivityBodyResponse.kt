package com.dag.nexarbmobile.network.commonresponse

import android.os.Parcelable
import com.dag.nexarbmobile.data.common.TextFieldType
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ActivityBodyResponse(
    val pageName: String,
    val title: String,
    val textFields: List<TextField>
) : Parcelable

@Parcelize
data class TextField(
    val hint: String,
    val title: String,
    val key: String,
    val type: TextFieldType
) : Parcelable