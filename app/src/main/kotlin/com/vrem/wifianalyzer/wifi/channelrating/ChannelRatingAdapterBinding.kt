package com.vrem.wifianalyzer.wifi.channelrating

import android.view.View
import android.widget.RatingBar
import android.widget.TextView
import com.vrem.wifianalyzer.R
import com.vrem.wifianalyzer.databinding.ChannelRatingDetailsBinding

internal class ChannelRatingAdapterBinding {
    val root: View
    val channelNumber: TextView
    val accessPointCount: TextView
    val channelRating: RatingBar

    internal constructor(binding: ChannelRatingDetailsBinding) {
        root = binding.root
        channelNumber = binding.channelNumber
        accessPointCount = binding.accessPointCount
        channelRating = binding.channelRating
    }

    internal constructor(view: View) {
        root = view
        channelNumber = view.findViewById(R.id.channelNumber)
        accessPointCount = view.findViewById(R.id.accessPointCount)
        channelRating = view.findViewById(R.id.channelRating)
    }
}
