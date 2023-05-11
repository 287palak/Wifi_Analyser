package com.vrem.wifianalyzer.wifi.filter.adapter

import com.vrem.wifianalyzer.settings.Settings
import com.vrem.wifianalyzer.wifi.band.WiFiBand

class WiFiBandAdapter(values: Set<WiFiBand>) : EnumFilterAdapter<WiFiBand>(values, WiFiBand.values()) {
    override fun save(settings: Settings): Unit =
            settings.saveWiFiBands(selections)
}