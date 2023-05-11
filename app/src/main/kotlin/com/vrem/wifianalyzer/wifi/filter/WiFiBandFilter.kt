package com.vrem.wifianalyzer.wifi.filter

import android.app.AlertDialog
import com.vrem.wifianalyzer.R
import com.vrem.wifianalyzer.wifi.band.WiFiBand
import com.vrem.wifianalyzer.wifi.filter.adapter.WiFiBandAdapter

internal class WiFiBandFilter(wiFiBandAdapter: WiFiBandAdapter, alertDialog: AlertDialog) :
        EnumFilter<WiFiBand, WiFiBandAdapter>(
                mapOf(
                    WiFiBand.GHZ2 to R.id.filterWifiBand2,
                    WiFiBand.GHZ5 to R.id.filterWifiBand5,
                    WiFiBand.GHZ6 to R.id.filterWifiBand6
                ),
                wiFiBandAdapter,
                alertDialog,
                R.id.filterWiFiBand
        )