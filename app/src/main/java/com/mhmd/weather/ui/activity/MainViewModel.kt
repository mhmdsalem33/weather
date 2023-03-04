package com.mhmd.weather.ui.activity

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.JsonPrimitive
import com.mhmd.weather.data.local.WeatherTable
import com.mhmd.weather.domain.models.model.WeResponse
import com.mhmd.weather.domain.repository.LocalRepository
import com.mhmd.weather.domain.repository.MainRepository
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val localRepository : LocalRepository
    ) : ViewModel(){

    fun getWeatherResponse(cityName : String , appKey : String) =  viewModelScope.launch(Dispatchers.IO){
        try {
            val response = mainRepository.getWeatherResponse(cityName, appKey)
            if (response.isSuccessful)
            {
                val dataJsonObject = Gson().toJson(response.body())
                upsertWeather(WeatherTable(json = dataJsonObject ))
            }
            else
            {
                Log.d("testApp" , response.code().toString())
            }

        }catch (e : Exception)
        {
            Log.d("testApp" , e.message.toString())
        }
    }

    private suspend fun upsertWeather(weather : WeatherTable) = viewModelScope.launch {
          localRepository.upsertWeather(weather)
    }
    suspend fun getDataFromLocal() = localRepository.getDataFromLocal()
}