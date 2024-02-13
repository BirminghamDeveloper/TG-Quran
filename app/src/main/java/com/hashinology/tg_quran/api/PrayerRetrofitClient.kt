package com.hashinology.tg_quran.api

import com.hashinology.tg_quran.models.PrayerResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PrayerRetrofitClient {
    @GET("/v1/timingsByCity/12-02-2024{city}{country}{method}")
    fun getTimeList(
        @Path("city") city: String,
        @Path("country") country: String,
        @Path("method") method: Int
    ): Response<PrayerResponse>

    companion object{
        var instance: PrayerRetrofitClient? = null
        @JvmName("getInstance1")
        fun getInstance(): PrayerRetrofitClient{
            if (instance == null){
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.aladhan.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                instance = retrofit.create(PrayerRetrofitClient::class.java)
            }
            return instance!!
        }
    }
}