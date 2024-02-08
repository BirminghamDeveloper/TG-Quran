package com.hashinology.tg_quran.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.hashinology.tg_quran.R
import com.hashinology.tg_quran.adapter.SuraDetailsAdapter
import com.hashinology.tg_quran.databinding.ActivitySurahDetailsBinding

class SurahDetailsActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivitySurahDetailsBinding
    lateinit var adapter: SuraDetailsAdapter
    var suraPosition: Int? = null
    var suraName: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySurahDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initViews()
    }

    private fun initViews() {
        suraName = intent.getStringExtra("sura_name")
        suraPosition = intent.getIntExtra("sura_number", 1)
        adapter = SuraDetailsAdapter(null)
        readDataFromFile()
        viewBinding.rvSurah.adapter = adapter
        viewBinding.tvTitle.text = suraName
    }

    //i return sura numb + name
    fun readDataFromFile() {
        val fileContent = assets.open("$suraPosition.txt").bufferedReader().use {
            it.readText()
        }
        val data = fileContent.split("\n")
        adapter.updateDate(data)
    }
}