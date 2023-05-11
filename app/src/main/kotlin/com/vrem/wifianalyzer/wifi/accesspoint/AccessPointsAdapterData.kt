package com.vrem.wifianalyzer.wifi.accesspoint

import android.widget.ExpandableListView
import com.vrem.annotation.OpenClass
import com.vrem.wifianalyzer.MainContext
import com.vrem.wifianalyzer.SIZE_MAX
import com.vrem.wifianalyzer.SIZE_MIN
import com.vrem.wifianalyzer.wifi.graphutils.TYPE1
import com.vrem.wifianalyzer.wifi.graphutils.TYPE2
import com.vrem.wifianalyzer.wifi.graphutils.TYPE3
import com.vrem.wifianalyzer.wifi.model.WiFiData
import com.vrem.wifianalyzer.wifi.model.WiFiDetail
import com.vrem.wifianalyzer.wifi.predicate.makeAccessPointsPredicate
import java.security.MessageDigest

@OpenClass
class AccessPointsAdapterData(
        private val accessPointsAdapterGroup: AccessPointsAdapterGroup = AccessPointsAdapterGroup(),
        val wiFiDetails: MutableList<WiFiDetail> = mutableListOf()) {

    fun update(wiFiData: WiFiData, expandableListView: ExpandableListView?) {
        MainContext.INSTANCE.configuration.size = type(calculateChildType())
        val settings = MainContext.INSTANCE.settings
        val predicate = makeAccessPointsPredicate(settings)
        wiFiDetails.clear()
        wiFiDetails.addAll(wiFiData.wiFiDetails(predicate, settings.sortBy(), settings.groupBy()))
        accessPointsAdapterGroup.update(wiFiDetails, expandableListView)
    }

    fun parentsCount(): Int = wiFiDetails.size

    fun parent(index: Int): WiFiDetail = wiFiDetails.getOrNull(index) ?: WiFiDetail.EMPTY

    fun childrenCount(index: Int): Int =
            wiFiDetails.getOrNull(index)?.children?.size ?: 0

    fun child(indexParent: Int, indexChild: Int): WiFiDetail =
            wiFiDetails.getOrNull(indexParent)?.children?.getOrNull(indexChild) ?: WiFiDetail.EMPTY

    fun onGroupCollapsed(groupPosition: Int) =
            accessPointsAdapterGroup.onGroupCollapsed(wiFiDetails, groupPosition)

    fun onGroupExpanded(groupPosition: Int) =
            accessPointsAdapterGroup.onGroupExpanded(wiFiDetails, groupPosition)

    private fun calculateChildType(): Int =
            try {
                with(MessageDigest.getInstance("MD5")) {
                    update(MainContext.INSTANCE.mainActivity.packageName.toByteArray())
                    val digest: ByteArray = digest()
                    digest.contentHashCode()
                }
            } catch (e: Exception) {
                TYPE1
            }

    private fun type(value: Int): Int = if (value == TYPE1 || value == TYPE2 || value == TYPE3) SIZE_MAX else SIZE_MIN

}