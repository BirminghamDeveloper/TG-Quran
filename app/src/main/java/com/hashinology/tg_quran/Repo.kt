package com.hashinology.tg_quran

import com.hashinology.tg_quran.api.PrayerRetrofitClient

class Repo {
    suspend fun getPrayerTime(city: String, country: String,method: Int) = PrayerRetrofitClient.getInstance().getTimeList(city, country, method)
}