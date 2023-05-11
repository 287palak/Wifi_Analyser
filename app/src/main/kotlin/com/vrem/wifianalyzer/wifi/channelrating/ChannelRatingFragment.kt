package com.vrem.wifianalyzer.wifi.channelrating

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.vrem.util.buildVersionP
import com.vrem.wifianalyzer.MainContext
import com.vrem.wifianalyzer.R
import com.vrem.wifianalyzer.databinding.ChannelRatingContentBinding

class ChannelRatingFragment : Fragment(), OnRefreshListener {
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    lateinit var channelRatingAdapter: ChannelRatingAdapter
        private set

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding: ChannelRatingContentBinding = ChannelRatingContentBinding.inflate(inflater, container, false)
        swipeRefreshLayout = binding.channelRatingRefresh
        swipeRefreshLayout.setOnRefreshListener(this)
        if (buildVersionP()) {
            swipeRefreshLayout.isRefreshing = false
            swipeRefreshLayout.isEnabled = false
        }
        val bestChannels: TextView = binding.channelRatingBest.channelRatingBestChannels
        channelRatingAdapter = ChannelRatingAdapter(requireActivity(), bestChannels)
        val listView: ListView = binding.channelRatingRefresh.findViewById(R.id.channelRatingView)
        listView.adapter = channelRatingAdapter
        return binding.root
    }

    override fun onRefresh() {
        swipeRefreshLayout.isRefreshing = true
        MainContext.INSTANCE.scannerService.update()
        swipeRefreshLayout.isRefreshing = false
    }

    override fun onResume() {
        super.onResume()
        MainContext.INSTANCE.scannerService.register(channelRatingAdapter)
        onRefresh()
    }

    override fun onPause() {
        MainContext.INSTANCE.scannerService.unregister(channelRatingAdapter)
        super.onPause()
    }

}