package com.vrem.wifianalyzer.wifi.channelgraph

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.vrem.util.buildVersionP
import com.vrem.wifianalyzer.MainContext
import com.vrem.wifianalyzer.databinding.GraphContentBinding

class ChannelGraphFragment : Fragment(), OnRefreshListener {
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    lateinit var channelGraphAdapter: ChannelGraphAdapter
        private set

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = GraphContentBinding.inflate(inflater, container, false)
        swipeRefreshLayout = binding.graphRefresh
        swipeRefreshLayout.setOnRefreshListener(this)
        if (buildVersionP()) {
            swipeRefreshLayout.isRefreshing = false
            swipeRefreshLayout.isEnabled = false
        }
        val linearLayout: LinearLayout = binding.graphNavigation
        val channelGraphNavigation = ChannelGraphNavigation(linearLayout, requireActivity().applicationContext)
        channelGraphAdapter = ChannelGraphAdapter(channelGraphNavigation)
        channelGraphAdapter.graphViews().forEach { binding.graphFlipper.addView(it) }
        return binding.root
    }

    override fun onRefresh() {
        swipeRefreshLayout.isRefreshing = true
        MainContext.INSTANCE.scannerService.update()
        swipeRefreshLayout.isRefreshing = false
    }

    override fun onResume() {
        super.onResume()
        MainContext.INSTANCE.scannerService.register(channelGraphAdapter)
        onRefresh()
    }

    override fun onPause() {
        MainContext.INSTANCE.scannerService.unregister(channelGraphAdapter)
        super.onPause()
    }

}