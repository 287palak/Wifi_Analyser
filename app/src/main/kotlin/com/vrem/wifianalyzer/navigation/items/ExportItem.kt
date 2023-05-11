package com.vrem.wifianalyzer.navigation.items

import android.content.ActivityNotFoundException
import android.content.Intent
import android.view.MenuItem
import android.widget.Toast
import com.vrem.wifianalyzer.MainActivity
import com.vrem.wifianalyzer.MainContext
import com.vrem.wifianalyzer.R
import com.vrem.wifianalyzer.export.Export
import com.vrem.wifianalyzer.navigation.NavigationMenu
import com.vrem.wifianalyzer.wifi.model.WiFiDetail

internal class ExportItem(private val export: Export) : NavigationItem {

    override fun activate(mainActivity: MainActivity, menuItem: MenuItem, navigationMenu: NavigationMenu) {
        val wiFiDetails: List<WiFiDetail> = MainContext.INSTANCE.scannerService.wiFiData().wiFiDetails
        if (wiFiDetails.isEmpty()) {
            Toast.makeText(mainActivity, R.string.no_data, Toast.LENGTH_LONG).show()
            return
        }
        val intent: Intent = export.export(mainActivity, wiFiDetails)
        if (!exportAvailable(mainActivity, intent)) {
            Toast.makeText(mainActivity, R.string.export_not_available, Toast.LENGTH_LONG).show()
            return
        }
        try {
            mainActivity.startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(mainActivity, e.localizedMessage, Toast.LENGTH_LONG).show()
        }
    }

    private fun exportAvailable(mainActivity: MainActivity, chooser: Intent): Boolean =
            chooser.resolveActivity(mainActivity.packageManager) != null

}