package com.vrem.wifianalyzer.wifi.accesspoint

import androidx.annotation.LayoutRes
import com.vrem.wifianalyzer.R

enum class AccessPointViewType(@LayoutRes val layout: Int) {
    COMPLETE(R.layout.access_point_view_complete),
    COMPACT(R.layout.access_point_view_compact);
}