package com.dag.nexarbmobile.dailogbox.authentication

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.dag.nexarbmobile.R
import com.dag.nexarbmobile.base.NexarbSessionUtil
import com.dag.nexarbmobile.base.ext.openActivity
import com.dag.nexarbmobile.base.ui.base.NexarbViewState
import com.dag.nexarbmobile.dailogbox.DefaultModelDialog
import com.dag.nexarbmobile.dailogbox.ModelDialog
import com.dag.nexarbmobile.dailogbox.ModelDialogButton
import com.dag.nexarbmobile.dailogbox.ModelDialogHandler
import javax.inject.Inject

object SessionTimeoutViewEffect: NexarbViewState

class SessionTimeoutHandler @Inject constructor(
    private val modelDialogHandler: ModelDialogHandler,
){

    fun handle(activity: FragmentActivity){
        NexarbSessionUtil.isSessionEndingProcessStarted = true
        modelDialogHandler.showDialog(activity,createUnAuthenticateDialog(activity))
    }

    private fun createUnAuthenticateDialog(activity: FragmentActivity): ModelDialog {
        return DefaultModelDialog(
            titleRes = R.string.app_name,
            messageRes = R.string.app_name,
            positiveButton = ModelDialogButton(
                textRes = R.string.app_name,
                onClick = {
                    NexarbSessionUtil.endSession()
                    /*activity.openActivity(
                        Intent(activity, HomeActivity::class.java)
                    )*/
                }
            ),
            isCancelable = false
        )
    }

}