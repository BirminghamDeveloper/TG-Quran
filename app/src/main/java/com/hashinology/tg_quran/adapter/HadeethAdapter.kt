package com.hashinology.tg_quran.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hashinology.tg_quran.OnItemClickHadeeth
import com.hashinology.tg_quran.constants.DataClassHadeth
import com.hashinology.tg_quran.databinding.FragmentHadieethBinding
import com.hashinology.tg_quran.databinding.ItemRecylerviewNameHadethBinding

class HadeethAdapter(
    val list: List<String>,
    var onItemClickHadeeth: OnItemClickHadeeth
): RecyclerView.Adapter<HadeethAdapter.ViewsHolders>() {
//    lateinit var viewBinding : ItemRecylerviewNameHadethBinding


    class ViewsHolders(val viewBinding: ItemRecylerviewNameHadethBinding): RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewsHolders {
        val view = ItemRecylerviewNameHadethBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewsHolders(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewsHolders, position: Int) {
        val item = list[position]
        holder.viewBinding.tvContainer.text = item
        holder.viewBinding.tvContainer.setOnClickListener {
            onItemClickHadeeth!!.onItemClickHadeeth(position, item)
        }
    }
}