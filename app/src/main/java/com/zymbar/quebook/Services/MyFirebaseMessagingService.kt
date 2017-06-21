package com.zymbar.quebook.Services

import android.app.AlertDialog
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.support.v4.content.LocalBroadcastManager
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService()  {

    private var TAG: String = "SERVICE2"

    private var broadcaster: LocalBroadcastManager? = null

    override fun onCreate() {
        broadcaster = LocalBroadcastManager.getInstance(this)
    }

    override fun onMessageReceived(p0: RemoteMessage?) {
        super.onMessageReceived(p0)

        var message: String = p0?.data!!["message"].toString()

        var i: Intent = Intent("data")
        i.putExtra("message", message)

        broadcaster?.sendBroadcast(i)
    }
}
