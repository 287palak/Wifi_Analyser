package com.vrem.wifianalyzer

import android.content.Context
import android.content.res.Resources
import android.net.wifi.WifiManager
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import com.vrem.wifianalyzer.settings.Repository
import com.vrem.wifianalyzer.settings.Settings
import com.vrem.wifianalyzer.vendor.model.VendorService
import com.vrem.wifianalyzer.wifi.filter.adapter.FiltersAdapter
import com.vrem.wifianalyzer.wifi.manager.WiFiManagerWrapper
import com.vrem.wifianalyzer.wifi.scanner.ScannerService
import com.vrem.wifianalyzer.wifi.scanner.makeScannerService

enum class MainContext {
    INSTANCE;

    lateinit var settings: Settings
    lateinit var mainActivity: MainActivity
    lateinit var wiFiManagerWrapper: WiFiManagerWrapper
    lateinit var scannerService: ScannerService
    lateinit var vendorService: VendorService
    lateinit var configuration: Configuration
    lateinit var filtersAdapter: FiltersAdapter

    val context: Context
        get() = mainActivity.applicationContext

    val resources: Resources
        get() = context.resources

    val layoutInflater: LayoutInflater
        get() = mainActivity.layoutInflater

    private val wiFiManager: WifiManager
        get() = context.getSystemService(Context.WIFI_SERVICE) as WifiManager

    fun initialize(activity: MainActivity, largeScreen: Boolean) {
        mainActivity = activity
        configuration = Configuration(largeScreen)
        settings = Settings(Repository(context))
        vendorService = VendorService(activity.resources)
        wiFiManagerWrapper = WiFiManagerWrapper(wiFiManager)
        scannerService = makeScannerService(mainActivity, wiFiManagerWrapper, Handler(Looper.getMainLooper()), settings)
        filtersAdapter = FiltersAdapter(settings)
    }

}