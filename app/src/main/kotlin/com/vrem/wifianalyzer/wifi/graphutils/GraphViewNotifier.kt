package com.vrem.wifianalyzer.wifi.graphutils

import com.jjoe64.graphview.GraphView
import com.vrem.wifianalyzer.wifi.model.WiFiData

interface GraphViewNotifier {
    fun graphView(): GraphView
    fun update(wiFiData: WiFiData)
}