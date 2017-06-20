package com.zymbar.quebook.Services

import android.app.AlertDialog
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService()  {

    private var TAG: String = "SERVICE2"

    override fun onMessageReceived(p0: RemoteMessage?) {
        super.onMessageReceived(p0)

        Log.d(TAG, "From: " + p0?.from)

        // Check if message contains a data payload.
        if (p0?.data?.size!! > 0) {
            Log.d(TAG, "Message data payload: " + p0?.data["message"])
        }

        // Check if message contains a notification payload.
        if (p0?.notification != null) {
            Log.d(TAG, "Message Notification Body: " + p0?.notification.body)
        }
    }
}
