package com.vrem.wifianalyzer.navigation.items

import android.view.MenuItem
import com.vrem.wifianalyzer.MainActivity
import com.vrem.wifianalyzer.navigation.NavigationMenu

interface NavigationItem {
    fun activate(mainActivity: MainActivity, menuItem: MenuItem, navigationMenu: NavigationMenu)
    val registered: Boolean
        get() = false
    val visibility: Int
        get() = android.view.View.GONE
}