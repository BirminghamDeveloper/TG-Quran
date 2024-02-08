package com.hashinology.tg_quran.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.hashinology.tg_quran.R
import com.hashinology.tg_quran.databinding.ActivitySurahDetailsBinding

class SurahDetailsActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivitySurahDetailsBinding
    var suraPosition: Int? = null
    var suraName: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySurahDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initViews()
    }

    private fun initViews() {

    }

    //i return sura numb + name
    fun readDataFromFile() {
        val fileContent = assets.open("$suraPosition.txt").bufferedReader().use {
            it.readText()
        }
    }
}