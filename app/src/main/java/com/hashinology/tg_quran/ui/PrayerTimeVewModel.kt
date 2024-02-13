package com.hashinology.tg_quran.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hashinology.tg_quran.Repo
import com.hashinology.tg_quran.models.PrayerResponse
import kotlinx.coroutines.launch

class PrayerTimeVewModel: ViewModel() {
    private var _getTime: MutableLiveData<PrayerResponse> = MutableLiveData()
    var getTime: LiveData<PrayerResponse> = _getTime

    fun getTime(city: String, country: String, method: Int) = viewModelScope.launch{
        val repo = Repo()
        var data = repo.getPrayerTime(city, country, method)
        if (data.isSuccessful){
            _getTime.postValue(data.body())
        }
    }
}