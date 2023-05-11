package com.vrem.wifianalyzer.wifi.channelavailable

import android.view.View
import android.widget.TextView
import com.vrem.wifianalyzer.R
import com.vrem.wifianalyzer.databinding.ChannelAvailableDetailsBinding

internal class ChannelAvailableAdapterBinding {
    val root: View
    val channelAvailableCountry: TextView
    val channelAvailableTitleGhz2: TextView
    val channelAvailableGhz2: TextView
    val channelAvailableTitleGhz5: TextView
    val channelAvailableGhz5: TextView
    val channelAvailableTitleGhz6: TextView
    val channelAvailableGhz6: TextView

    internal constructor(binding: ChannelAvailableDetailsBinding) {
        root = binding.root
        channelAvailableCountry = binding.channelAvailableCountry
        channelAvailableTitleGhz2 = binding.channelAvailableTitleGhz2
        channelAvailableGhz2 = binding.channelAvailableGhz2
        channelAvailableTitleGhz5 = binding.channelAvailableTitleGhz5
        channelAvailableGhz5 = binding.channelAvailableGhz5
        channelAvailableTitleGhz6 = binding.channelAvailableTitleGhz6
        channelAvailableGhz6 = binding.channelAvailableGhz6
    }

    internal constructor(view: View) {
        root = view
        channelAvailableCountry = view.findViewById(R.id.channel_available_country)
        channelAvailableTitleGhz2 = view.findViewById(R.id.channel_available_title_ghz_2)
        channelAvailableGhz2 = view.findViewById(R.id.channel_available_ghz_2)
        channelAvailableTitleGhz5 = view.findViewById(R.id.channel_available_title_ghz_5)
        channelAvailableGhz5 = view.findViewById(R.id.channel_available_ghz_5)
        channelAvailableTitleGhz6 = view.findViewById(R.id.channel_available_title_ghz_6)
        channelAvailableGhz6 = view.findViewById(R.id.channel_available_ghz_6)
    }

}
