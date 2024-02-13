package com.dag.nexarbmobile.session

import javax.inject.Inject


class NexarbSessionManager @Inject constructor(){
    private val sessionList:HashMap<String,Any> = HashMap()

    fun addData(key:String,data:Any) = sessionList.put(key,data)

    fun <T> getData(key: String):T? = sessionList[key] as? T

    fun contains(key: String) = sessionList[key] != null

}