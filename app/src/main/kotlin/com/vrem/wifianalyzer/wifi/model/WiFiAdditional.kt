package com.vrem.wifianalyzer.wifi.model

import com.vrem.util.EMPTY

class WiFiAdditional(val vendorName: String = String.EMPTY,
                     val wiFiConnection: WiFiConnection = WiFiConnection.EMPTY) {

    companion object {
        val EMPTY = WiFiAdditional()
    }

}