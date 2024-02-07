package com.hashinology.tg_quran.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hashinology.tg_quran.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        initViews()
    }

    private fun initViews() {
        TODO("Not yet implemented")
    }
}