package com.hashinology.tg_quran.ui

import com.hashinology.tg_quran.ui.fragments.SurahFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.hashinology.tg_quran.R
import com.hashinology.tg_quran.databinding.ActivityHomeBinding
import com.hashinology.tg_quran.ui.fragments.HadieethFragment
import com.hashinology.tg_quran.ui.fragments.RadioFragment
import com.hashinology.tg_quran.ui.fragments.PrayerTimeFragment


class HomeActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        initViews()
    }

    private fun initViews() {
        // have main fragment --> Bottom-Naviagtion
        navvigateFragment()
    }

    private fun navvigateFragment() {
        viewBinding.bottomNavigationView.setOnItemSelectedListener {
            if (it.itemId == R.id.Quran_Frag) {
                navigateTo(SurahFragment())
            } else if (it.itemId == R.id.Hadeeth_Frag) {
                navigateTo(HadieethFragment())
            } else if (it.itemId == R.id.Tasbeh_Frag) {
                navigateTo(PrayerTimeFragment())
            } else if (it.itemId == R.id.Radio_Frag) {
                navigateTo(RadioFragment())
            }
            return@setOnItemSelectedListener true
        }
    }

    override fun onStart() {
        super.onStart()
        navigateTo(SurahFragment())
    }

    private fun navigateTo(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainFragement, fragment)
            .commit()
    }
}