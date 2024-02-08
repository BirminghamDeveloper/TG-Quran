package com.hashinology.tg_quran

import com.hashinology.tg_quran.constants.SurahData

interface OnItemClick {
    fun onItemClickListner(surahName: SurahData)
}