package com.vrem.wifianalyzer.wifi.timegraph

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.vrem.util.buildVersionP
import com.vrem.wifianalyzer.MainContext
import com.vrem.wifianalyzer.databinding.GraphContentBinding
import com.vrem.wifianalyzer.wifi.band.WiFiBand
import com.vrem.wifianalyzer.wifi.graphutils.GraphAdapter

private fun timeGraphViews(): List<TimeGraphView> = WiFiBand.values().map { TimeGraphView(it) }

class TimeGraphAdapter : GraphAdapter(timeGraphViews())

class TimeGraphFragment : Fragment(), OnRefreshListener {
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    lateinit var timeGraphAdapter: TimeGraphAdapter
        private set

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = GraphContentBinding.inflate(inflater, container, false)
        swipeRefreshLayout = binding.graphRefresh
        swipeRefreshLayout.setOnRefreshListener(this)
        if (buildVersionP()) {
            swipeRefreshLayout.isRefreshing = false
            swipeRefreshLayout.isEnabled = false
        }
        timeGraphAdapter = TimeGraphAdapter()
        timeGraphAdapter.graphViews().forEach { binding.graphFlipper.addView(it) }
        return binding.root
    }

    override fun onRefresh() {
        swipeRefreshLayout.isRefreshing = true
        MainContext.INSTANCE.scannerService.update()
        swipeRefreshLayout.isRefreshing = false
    }

    override fun onResume() {
        super.onResume()
        MainContext.INSTANCE.scannerService.register(timeGraphAdapter)
        onRefresh()
    }

    override fun onPause() {
        MainContext.INSTANCE.scannerService.unregister(timeGraphAdapter)
        super.onPause()
    }

}