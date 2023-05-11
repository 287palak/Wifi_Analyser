package com.vrem.wifianalyzer.wifi.scanner

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import com.vrem.annotation.OpenClass
import com.vrem.wifianalyzer.MainActivity

internal interface Callback {
    fun onSuccess()
}

@OpenClass
internal class ScanResultsReceiver(private val mainActivity: MainActivity, private val callback: Callback) :
    BroadcastReceiver() {
    private var registered = false

    fun register() {
        if (!registered) {
            mainActivity.registerReceiver(this, makeIntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION))
            registered = true
        }
    }

    fun unregister() {
        if (registered) {
            mainActivity.unregisterReceiver(this)
            registered = false
        }
    }

    fun makeIntentFilter(action: String): IntentFilter = IntentFilter(action)

    override fun onReceive(context: Context, intent: Intent) {
        if (WifiManager.SCAN_RESULTS_AVAILABLE_ACTION == intent.action) {
            if (intent.getBooleanExtra(WifiManager.EXTRA_RESULTS_UPDATED, false)) {
                callback.onSuccess()
            }
        }
    }
}