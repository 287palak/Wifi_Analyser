package com.vrem.wifianalyzer.wifi.filter.adapter

import com.vrem.annotation.OpenClass
import com.vrem.wifianalyzer.settings.Settings

@OpenClass
abstract class BasicFilterAdapter<T>(open var selections: Set<T>) {
    fun selections(selections: Array<T>) {
        this.selections = selections.toSet()
    }

    abstract fun isActive(): Boolean
    abstract fun reset()
    abstract fun save(settings: Settings)
}