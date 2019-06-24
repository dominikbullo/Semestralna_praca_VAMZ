package com.example.semestralna_praca_vamz

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {
    val TAG = "MyService"

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        showLog("onCreate")
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        showLog("onStartCommand")

        val runable = Runnable {
            for (i in 1..100) {
                showLog("Service doing something." + i.toString())
                Thread.sleep(1000)
            }
            stopSelf()
        }

        val thread = Thread(runable)
        thread.start()

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        showLog("onStartCommand")
        super.onDestroy()
    }

    fun showLog(message: String) {
        Log.d(TAG, message)
    }
}
