package com.dag.nexarbmobile.base

import android.app.Activity
import com.dag.nexarbmobile.base.ext.tryCatch
import com.dag.nexarbmobile.base.ui.NexarbNavigator
import com.dag.nexarbmobile.base.ui.base.NexarbActivity
import com.dag.nexarbmobile.dailogbox.*
import com.dag.nexarbmobile.injection.NetworkModule
import com.dag.nexarbmobile.network.BaseResult
import com.dag.nexarbmobile.network.NexarbService
import com.google.gson.JsonParser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject
import javax.inject.Named

class BaseDialogBoxUtil @Inject constructor(
    private val clNavigator: NexarbNavigator,
    @Named(NetworkModule.AUTHENTICATED_SERVICE) private val service: NexarbService,
    private val nexarbActivityListener: NexarbActivityListener
){
    var baseDialogBoxCustomActionListener: BaseDialogBoxCustomActionListener? = null
    interface BaseDialogBoxCustomActionListener{
        fun baseDialogBoxCustomAction(buttonModel: ButtonModel? = null)
    }

    fun showGenericDialog(dialogBox: DialogBoxModel, activity:Activity? = nexarbActivityListener.currentActivity){
        activity?.run {
            if (activity.isFinishing){
                return
            }

        }
    }

    private fun buttonAction(buttonModel: ButtonModel?, activity: Activity?){
        when(buttonModel?.actionType){
            ButtonActionType.CUSTOM -> baseDialogBoxCustomActionListener?.baseDialogBoxCustomAction()
            ButtonActionType.GO_BACK -> tryCatch({activity?.onBackPressed()})
            ButtonActionType.DISMISS -> Unit
            ButtonActionType.REQUEST ->{
                if (buttonModel.onPressed != null){
                    buttonModel.onPressed?.invoke()
                }else{
                    sendGenericRequest(activity,buttonModel.requestModel)
                }
            }
            else -> {buttonModel?.onPressed?.invoke()}
        }
    }

    fun sendGenericRequest(activity: Activity?, requestModel: RequestModel?, onSuccess:()->Unit = {}){
        if (activity is NexarbActivity<*, *>) {
            var body: Any? = null
            if (!requestModel?.body.isNullOrEmpty()) {
                body = hashMapOf<String, Any>().apply {
                    requestModel?.body?.forEach {
                        if (it.key is String && it.value != null) {
                            put(it.key, it.value)
                        }
                    }
                }
            } else if (requestModel?.bodyAsJsonString?.isEmpty() == false) {
                body = JsonParser.parseString(requestModel.bodyAsJsonString).asJsonObject
            }

            val requestFunction = when(requestModel?.method){
                RequestMethodType.POST -> service.genericPostRequest(requestModel.url,body)
                RequestMethodType.GET -> service.genericGetRequest(requestModel.url)
                RequestMethodType.DELETE -> service.genericDeleteRequest(requestModel.url)
                RequestMethodType.PUT -> service.genericPutRequest(requestModel.url,body)
                else -> {null}
            }
            tryCatch(
                tryBlock ={
                    (requestFunction as? BaseResult<*>)?.run {
                        CoroutineScope(Dispatchers.IO).launch {
                            onSuccess.invoke()
                        }
                    }
                }
            )
        }
    }

}