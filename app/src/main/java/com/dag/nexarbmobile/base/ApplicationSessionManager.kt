package com.dag.nexarbmobile.base

import android.os.CountDownTimer
import java.util.*

class ApplicationSessionManager {

    companion object {
        val NexarbSession = NexarbSession()

        var isSessionEndingProcessStarted = false

        fun startSession(sessionTimeOutInSeconds: Long) {
            NexarbSession.startSession(sessionTimeOutInSeconds)
        }

        fun restartSessionTime() {
            NexarbSession.restartSessionTime()
        }

        fun endSession() {
            isSessionEndingProcessStarted = false
            NexarbSession.endSession()
        }

        fun addObserver(observer: Observer) {
            NexarbSession.addObserver(observer)
        }

        fun deleteObserver(observer: Observer) {
            NexarbSession.deleteObserver(observer)
        }

        fun deleteObservers() {
            NexarbSession.deleteObservers()
        }
    }

    class NexarbSession : Observable() {

        var sessionStarted: Boolean = false
            private set
        private var timer: CountDownTimer? = null

        fun startSession(sessionTimeOutInSeconds: Long) {
            if (timer == null) {
                timer = object : CountDownTimer(sessionTimeOutInSeconds * 1000, 1000L) {
                    override fun onFinish() {
                        sessionStarted = false
                        setChanged()
                        notifyObservers() // session timeout
                    }

                    override fun onTick(millisUntilFinished: Long) {
                    }
                }
            }

            sessionStarted = true
            timer?.cancel()
            timer?.start()
        }

        fun restartSessionTime() {
            if (sessionStarted) {
                timer?.cancel()
                timer?.start()
            }
        }

        fun endSession() {
            timer?.cancel()
            sessionStarted = false
        }
    }
}