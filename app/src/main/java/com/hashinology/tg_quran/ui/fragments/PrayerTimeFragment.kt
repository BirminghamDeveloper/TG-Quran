package com.hashinology.tg_quran.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.hashinology.tg_quran.databinding.FragmentTimePrayerBinding
import com.hashinology.tg_quran.ui.PrayerTimeVewModel

class PrayerTimeFragment : Fragment() {
    lateinit var viewBinding: FragmentTimePrayerBinding
    val vm: PrayerTimeVewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinding = FragmentTimePrayerBinding.inflate(layoutInflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.getTime("Dubai", "United Arab Emirates", 8)
        vm.getTime.observe(viewLifecycleOwner, Observer{ it ->
            viewBinding.tvCity.text = it.data.meta.timezone
            viewBinding.tvTime.text = it.data.timings.Asr
        })
    }
}