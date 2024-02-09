package com.hashinology.tg_quran.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hashinology.tg_quran.OnItemClickQuran
import com.hashinology.tg_quran.constants.SurahData
import com.hashinology.tg_quran.databinding.SurahListItemBinding

class SurahAdapter(
    val list: List<SurahData>
) : RecyclerView.Adapter<SurahAdapter.ViewHolders>() {
    var onItemClick: OnItemClickQuran? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurahAdapter.ViewHolders {
        val view = SurahListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolders(view)
    }

    override fun onBindViewHolder(holder: SurahAdapter.ViewHolders, position: Int) {
//        val surah = list.get(position + 1)
        val surah = list[position]
        holder.viewBinding.tvSuraName.text = surah.surahName
        holder.viewBinding.tvSurahNumb.text = surah.surahNumber.toString()

        holder.viewBinding.surahContainer.setOnClickListener {
            onItemClick?.onItemClickListner(surah)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolders(val viewBinding: SurahListItemBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

    }
}