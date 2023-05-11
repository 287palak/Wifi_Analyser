package com.vrem.wifianalyzer.wifi.filter

import android.app.AlertDialog
import com.vrem.wifianalyzer.R
import com.vrem.wifianalyzer.wifi.filter.adapter.SecurityAdapter
import com.vrem.wifianalyzer.wifi.model.Security

internal class SecurityFilter(securityAdapter: SecurityAdapter, alertDialog: AlertDialog) :
        EnumFilter<Security, SecurityAdapter>(
                mapOf(
                        Security.NONE to R.id.filterSecurityNone,
                        Security.WPS to R.id.filterSecurityWPS,
                        Security.WEP to R.id.filterSecurityWEP,
                        Security.WPA to R.id.filterSecurityWPA,
                        Security.WPA2 to R.id.filterSecurityWPA2,
                        Security.WPA3 to R.id.filterSecurityWPA3
                ),
                securityAdapter,
                alertDialog,
                R.id.filterSecurity
        )
