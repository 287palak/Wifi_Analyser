package com.vrem.wifianalyzer.navigation.options

import android.annotation.SuppressLint
import android.app.Activity
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.view.menu.MenuBuilder
import com.vrem.annotation.OpenClass
import com.vrem.wifianalyzer.R

@OpenClass
class OptionMenu {
    var menu: Menu? = null

    fun create(activity: Activity, menu: Menu) {
        activity.menuInflater.inflate(R.menu.optionmenu, menu)
        this.menu = menu
        iconsVisible(menu)
    }

//    fun select(item: MenuItem): Unit = OptionAction.findOptionAction(item.itemId).action()

    @SuppressLint("RestrictedApi")
    private fun iconsVisible(menu: Menu) {
        try {
            (menu as MenuBuilder).setOptionalIconsVisible(true)
        } catch (e: Exception) {
            // do nothing
        }
    }
}