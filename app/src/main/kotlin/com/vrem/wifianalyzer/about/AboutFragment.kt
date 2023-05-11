package com.vrem.wifianalyzer.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import com.vrem.wifianalyzer.databinding.AboutContentBinding


class AboutFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding: AboutContentBinding = AboutContentBinding.inflate(inflater, container, false)
        return binding.root
    }

}