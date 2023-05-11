package com.vrem.wifianalyzer.wifi.filter.adapter

import com.vrem.wifianalyzer.settings.Settings
import com.vrem.wifianalyzer.wifi.model.Security

class SecurityAdapter(selections: Set<Security>) : EnumFilterAdapter<Security>(selections, Security.values()) {
    override fun save(settings: Settings) {
        settings.saveSecurities(selections)
    }
}