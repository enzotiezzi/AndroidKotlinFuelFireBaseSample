package com.zymbar.quebook.Interfaces

import android.content.Intent

/**
 * Created by enzo_ on 20/06/2017.
 */
interface MessageReceivedCallback {
    fun callback(intent: Intent)
}