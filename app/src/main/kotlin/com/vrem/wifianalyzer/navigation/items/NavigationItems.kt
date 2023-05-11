package com.vrem.wifianalyzer.navigation.items

import android.view.View
import com.vrem.wifianalyzer.about.AboutFragment
import com.vrem.wifianalyzer.export.Export
//import com.vrem.wifianalyzer.settings.SettingsFragment
//import com.vrem.wifianalyzer.vendor.VendorFragment
import com.vrem.wifianalyzer.wifi.accesspoint.AccessPointsFragment
//import com.vrem.wifianalyzer.wifi.channelavailable.ChannelAvailableFragment
import com.vrem.wifianalyzer.wifi.channelgraph.ChannelGraphFragment
import com.vrem.wifianalyzer.wifi.channelrating.ChannelRatingFragment
//import com.vrem.wifianalyzer.wifi.timegraph.TimeGraphFragment

val navigationItemAccessPoints: NavigationItem = FragmentItem(AccessPointsFragment())
val navigationItemChannelRating: NavigationItem = FragmentItem(ChannelRatingFragment())
val navigationItemChannelGraph: NavigationItem = FragmentItem(ChannelGraphFragment())
//val navigationItemTimeGraph: NavigationItem = FragmentItem(TimeGraphFragment())
val navigationItemExport: NavigationItem = ExportItem(Export())
//val navigationItemChannelAvailable: NavigationItem = FragmentItem(ChannelAvailableFragment(), false)
//val navigationItemVendors: NavigationItem = FragmentItem(VendorFragment(), false, View.GONE)
//val navigationItemSettings: NavigationItem = FragmentItem(SettingsFragment(), false, View.GONE)
val navigationItemAbout: NavigationItem = FragmentItem(AboutFragment(), false, View.GONE)
