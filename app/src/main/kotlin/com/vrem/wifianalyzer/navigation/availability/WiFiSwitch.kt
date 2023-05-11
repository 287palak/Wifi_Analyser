package com.vrem.wifianalyzer.navigation.availability

import com.vrem.wifianalyzer.MainActivity
import com.vrem.wifianalyzer.MainContext
import com.vrem.wifianalyzer.R

internal val navigationOptionWiFiSwitchOff: NavigationOption = {
    updateMenuItem(it, false)
}

internal val navigationOptionWiFiSwitchOn: NavigationOption = {
    updateMenuItem(it, true)
}

private fun updateMenuItem(mainActivity: MainActivity, visible: Boolean) {
    mainActivity.optionMenu.menu?.let {
        val menuItem = it.findItem(R.id.action_wifi_band)
        menuItem.isVisible = visible
        if (visible) {
            val wiFiBand = MainContext.INSTANCE.settings.wiFiBand()
            val title = mainActivity.getString(wiFiBand.textResource)
            menuItem.title = title.replace(' ', '\n')
        }
    }
}

