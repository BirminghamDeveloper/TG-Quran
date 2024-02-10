package com.hashinology.tg_quran.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.hashinology.tg_quran.HadethContantActivity
import com.hashinology.tg_quran.OnItemClickHadeeth
import com.hashinology.tg_quran.adapter.HadeethAdapter
import com.hashinology.tg_quran.constants.DataClassHadeth
import com.hashinology.tg_quran.constants.hadeethListTitle
import com.hashinology.tg_quran.databinding.FragmentHadieethBinding


class HadieethFragment : Fragment(), OnItemClickHadeeth
    {
    lateinit var hadeethAdapter: HadeethAdapter
    lateinit var viewBinding: FragmentHadieethBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinding = FragmentHadieethBinding.inflate(layoutInflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRV()
//        readfile()

    }

    private fun setUpRV() {
        hadeethAdapter = HadeethAdapter(hadeethListTitle, this)
        viewBinding.rvHadeeth.apply {
            adapter = hadeethAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }
    var allAhadeth = ArrayList<DataClassHadeth>()
    fun readfile(position: Int) {

        var fileName = "h${position +1}.txt"
        var filcontant = activity?.assets?.open(fileName)?.bufferedReader().use {
            it?.readText()
        }
        if (filcontant == null) return
        val ahadethContant = filcontant.trim().split("#")
        ahadethContant.forEach { singleHadethContent ->

            val title = singleHadethContent.trim().substringBefore('\n')
            val content = singleHadethContent.trim().substringAfter('\n')

            Log.e("title", title)
            Log.e("content", content)
            val hadeth = DataClassHadeth(title, content)
            allAhadeth.add(hadeth)
        }
    }

    override fun onItemClickHadeeth(position: Int, title: String) {
        readfile(position)
        var Intent = Intent(activity, HadethContantActivity::class.java)
        Intent.putExtra("hadeeth_position",position)
        Intent.putExtra("hadeeth_title", title)

        startActivity(Intent)
//        activity?.finish()
    }
}