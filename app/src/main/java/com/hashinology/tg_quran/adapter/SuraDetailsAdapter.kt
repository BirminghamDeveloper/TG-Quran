package com.hashinology.tg_quran.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hashinology.tg_quran.databinding.SurahVersesBinding

class SuraDetailsAdapter(
    val list: List<String>
): RecyclerView.Adapter<SuraDetailsAdapter.MyViewHolder>() {

    class MyViewHolder(val suraVerses: SurahVersesBinding): RecyclerView.ViewHolder(suraVerses.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = SurahVersesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}