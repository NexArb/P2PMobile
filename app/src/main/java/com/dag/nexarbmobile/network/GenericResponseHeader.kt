package com.dag.nexarbmobile.network

import android.content.Context
import android.view.*
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.dag.nexarbmobile.R

class GenericResponseHeader {

    companion object{
        private const val PROGRESS_BAR_ANIMATION_DURATION:Long = 1000

        fun<T:Any> onResponse(result:T?){}

        fun onError(error:Throwable?) {}

        fun showProgress(window:Window?,context:Context){

        }

        fun hideProgress(window: Window?){

        }
    }
}