package com.vrem.wifianalyzer.navigation

import android.view.MenuItem
import com.vrem.wifianalyzer.MainActivity
import com.vrem.wifianalyzer.R
import com.vrem.wifianalyzer.navigation.availability.*
import com.vrem.wifianalyzer.navigation.items.*

enum class NavigationMenu(val icon: Int,
                          val title: Int,
                          val navigationItem: NavigationItem,
                          val navigationOptions: List<NavigationOption> = navigationOptionOff) {
    ACCESS_POINTS(R.drawable.ic_network_wifi, R.string.action_access_points, navigationItemAccessPoints, navigationOptionAp),
    CHANNEL_RATING(R.drawable.ic_wifi_tethering, R.string.action_channel_rating, navigationItemChannelRating, navigationOptionRating),
    CHANNEL_GRAPH(R.drawable.ic_insert_chart, R.string.action_channel_graph, navigationItemChannelGraph, navigationOptionOther),
    EXPORT(R.drawable.ic_import_export, R.string.action_export, navigationItemExport),
    ABOUT(R.drawable.ic_info_outline, R.string.action_about, navigationItemAbout);

    fun activateNavigationMenu(mainActivity: MainActivity, menuItem: MenuItem): Unit =
            navigationItem.activate(mainActivity, menuItem, this)

    fun activateOptions(mainActivity: MainActivity): Unit = navigationOptions.forEach { it(mainActivity) }

//    fun wiFiBandSwitchable(): Boolean = navigationOptions.contains(navigationOptionWiFiSwitchOn)

    fun registered(): Boolean = navigationItem.registered

}