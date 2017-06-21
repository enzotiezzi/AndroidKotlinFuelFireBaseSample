package com.zymbar.quebook.Activities

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.support.v7.app.AlertDialog
import com.github.kittinunf.fuel.Fuel
import com.google.gson.Gson
import com.zymbar.quebook.Models.FireBaseDataModel
import com.zymbar.quebook.Models.FireBaseModel
import com.zymbar.quebook.R
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {

    private var _context: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        _context = this

        var token = "cMSjP2D5974:APA91bE08gKVjZHj9UF7MTudVNih51Zate-SN-sOabnmUCuqapCMVOmh1W3wro8HAyfaoscImYQoiDcGvc1i5iyg4h5Y5VBCCPiEJjnmQn-6GxbMpjsESyWDNVlhO1uVOrHSpDrh34vO"

        var url = "https://fcm.googleapis.com/fcm/send"
        var param = Gson().toJson(FireBaseModel(FireBaseDataModel("eae rapa"), token))

        Fuel.post(url)
                .body(param, Charset.forName("UTF-8"))
                .header(Pair("Content-Type", "application/json"))
                .header(Pair("Authorization", "key=AIzaSyAI07wGfZIGzWkREmFuZ80E9ykr_q7RR-Q"))
                .responseString { request, response, result ->
                    result.fold({ d ->
                        AlertDialog.Builder(this)
                                .setTitle("Resposta")
                                .setMessage(d)
                                .setNeutralButton("ok", null)
                                .show()
                    }, { e ->
                        AlertDialog.Builder(this)
                                .setTitle("Resposta")
                                .setMessage(e.message)
                                .setNeutralButton("ok", null)
                                .show()
                    })
                }
    }

    override fun onStart() {
        super.onStart()
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver, IntentFilter("data"))
    }

    override fun onStop() {
        super.onStop()
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver)
    }

    private var mMessageReceiver: BroadcastReceiver = object : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent != null) {
                var message = intent.extras.getString("message")
                AlertDialog.Builder(_context!!)
                        .setTitle("Resposta")
                        .setMessage(message)
                        .setNeutralButton("ok", null)
                        .show()
            }
        }
    }
}
