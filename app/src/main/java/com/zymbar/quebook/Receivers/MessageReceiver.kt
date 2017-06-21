package com.zymbar.quebook.Receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.zymbar.quebook.Interfaces.MessageReceivedCallback

class MessageReceiver : BroadcastReceiver() {

    private var _callback: MessageReceivedCallback? = null
    public var callback: MessageReceivedCallback? = null
        set(value) {
            this._callback = value
        }

    override fun onReceive(context: Context, intent: Intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        _callback?.callback(intent)
    }
}
