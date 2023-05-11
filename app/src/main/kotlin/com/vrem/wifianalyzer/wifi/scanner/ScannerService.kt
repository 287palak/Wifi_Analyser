package com.vrem.wifianalyzer.wifi.scanner

import android.os.Handler
import com.vrem.wifianalyzer.MainActivity
import com.vrem.wifianalyzer.permission.PermissionService
import com.vrem.wifianalyzer.settings.Settings
import com.vrem.wifianalyzer.wifi.manager.WiFiManagerWrapper
import com.vrem.wifianalyzer.wifi.model.WiFiData

interface UpdateNotifier {
    fun update(wiFiData: WiFiData)
}

interface ScannerService {
    fun update()
    fun wiFiData(): WiFiData
    fun register(updateNotifier: UpdateNotifier): Boolean
    fun unregister(updateNotifier: UpdateNotifier): Boolean
    fun pause()
    fun running(): Boolean
    fun resume()
    fun resumeWithDelay()
    fun stop()
    fun toggle()
}

fun makeScannerService(
    mainActivity: MainActivity,
    wiFiManagerWrapper: WiFiManagerWrapper,
    handler: Handler,
    settings: Settings
): ScannerService {
    val cache = Cache()
    val transformer = Transformer(cache)
    val permissionService = PermissionService(mainActivity)
    val scanner = Scanner(wiFiManagerWrapper, settings, permissionService, transformer)
    scanner.periodicScan = PeriodicScan(scanner, handler, settings)
    scanner.scannerCallback = ScannerCallback(wiFiManagerWrapper, cache)
    scanner.scanResultsReceiver = ScanResultsReceiver(mainActivity, scanner.scannerCallback)
    return scanner
}
