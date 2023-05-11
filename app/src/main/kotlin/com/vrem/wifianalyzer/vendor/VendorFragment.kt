package com.vrem.wifianalyzer.vendor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.ListFragment
import com.vrem.util.specialTrim
import com.vrem.wifianalyzer.MainContext
import com.vrem.wifianalyzer.databinding.VendorContentBinding

class VendorFragment : ListFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding: VendorContentBinding = VendorContentBinding.inflate(inflater, container, false)
        val vendorAdapter = VendorAdapter(requireActivity(), MainContext.INSTANCE.vendorService)
        listAdapter = vendorAdapter
        binding.vendorSearchText.setOnQueryTextListener(Listener(vendorAdapter))
        return binding.root
    }

    internal class Listener(private val vendorAdapter: VendorAdapter) : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String): Boolean = false

        override fun onQueryTextChange(newText: String): Boolean {
            vendorAdapter.update(newText.specialTrim())
            return true
        }

    }
}