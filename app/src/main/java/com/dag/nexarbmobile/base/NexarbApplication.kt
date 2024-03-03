package com.dag.nexarbmobile.base

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.ActivityInfo
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.dag.nexarbmobile.base.ext.lifeCycle
import com.dag.nexarbmobile.base.ui.base.NexarbActivity
import dagger.hilt.android.HiltAndroidApp
import java.util.*
import javax.inject.Inject

@HiltAndroidApp
class NexarbApplication : MultiDexApplication(), Observer {

    @Inject
    lateinit var nexarbActivityListener: NexarbActivityListener
    private var currentActivity: CanDropSession? = null
    lateinit var currentNexarbActivity: NexarbActivity<*,*>

    private var sessionShouldEnd = false

    companion object {

        lateinit var appInstance: NexarbApplication
        var baseUrl = "http://192.168.178.26:8080"
    }

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate() {
        super.onCreate()
        appInstance = this
        ApplicationSessionManager.addObserver(this)
        val nexarbAppLifeCycle = this.lifeCycle(
            activityCreated = {
                // All Activities Portrait
                it?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

            },
            activityResumed = {
                if (it is NexarbActivity<*,*>){
                    currentNexarbActivity = it
                }
                if (it is CanDropSession) {
                    currentActivity = it
                    if (sessionShouldEnd) {
                        currentActivity?.dropSession()
                        sessionShouldEnd = false
                    }
                }
            },
            activityPaused = {
                if (it == currentActivity) {
                    currentActivity = null
                }
            }
        )
        registerActivityLifecycleCallbacks(nexarbActivityListener)
        registerActivityLifecycleCallbacks(nexarbAppLifeCycle)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        ApplicationSessionManager.deleteObserver(this)
    }

    override fun update(p0: Observable?, p1: Any?) {
        sessionShouldEnd = true
        currentActivity?.let {
            it.dropSession()
            sessionShouldEnd = false
        }
    }
}