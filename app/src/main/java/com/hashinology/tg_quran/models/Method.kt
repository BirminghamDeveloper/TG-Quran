package com.hashinology.tg_quran.models

data class Method(
    val id: Int,
    val location: Location,
    val name: String,
    val params: Params
)