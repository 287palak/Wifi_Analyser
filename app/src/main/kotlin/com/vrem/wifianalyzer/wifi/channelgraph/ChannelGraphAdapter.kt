package com.vrem.wifianalyzer.wifi.channelgraph

import com.vrem.annotation.OpenClass
import com.vrem.wifianalyzer.wifi.band.WiFiBand
import com.vrem.wifianalyzer.wifi.graphutils.GraphAdapter
import com.vrem.wifianalyzer.wifi.model.WiFiData

private fun channelGraphViews(): List<ChannelGraphView> =
        WiFiBand.values().flatMap { wiFiBand ->
            wiFiBand.wiFiChannels.wiFiChannelPairs().map { ChannelGraphView(wiFiBand, it) }
        }

@OpenClass
class ChannelGraphAdapter(private val channelGraphNavigation: ChannelGraphNavigation) : GraphAdapter(channelGraphViews()) {
    override fun update(wiFiData: WiFiData) {
        super.update(wiFiData)
        channelGraphNavigation.update()
    }
}

