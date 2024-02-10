package com.hashinology.tg_quran

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hashinology.tg_quran.constants.DataClassHadeth
import com.hashinology.tg_quran.constants.hadeethListTitle
import com.hashinology.tg_quran.databinding.ActivityHadethContantBinding

class HadethContantActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityHadethContantBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHadethContantBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val hadeethContent = intent.getStringExtra("hadeeth_title")
        val hadeethNumber = intent.getIntExtra("hadeeth_position", 0)

        readfile(hadeethNumber +1)

        viewBinding.back.setOnClickListener {
            onBackPressed()
        }
    }

    fun readfile(position: Int) {

        var fileName = "h${position}.txt"
        var filcontant = this.assets?.open(fileName)?.bufferedReader().use {
            it?.readText()
        }
        if (filcontant == null) return
        val ahadethContant = filcontant.trim().split("#")
        ahadethContant.forEach { singleHadethContent ->

            val title = singleHadethContent.trim().substringBefore('\n')
            val content = singleHadethContent.trim().substringAfter('\n')

            Log.e("title", title)
            Log.e("content", content)

            viewBinding.actvityContent.HadeethName.text = title
            viewBinding.actvityContent.hadeethContent.text = content
        }
    }
}