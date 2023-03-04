package com.mhmd.weather.domain.repository

import com.mhmd.weather.data.network.WeatherApi
import javax.inject.Inject

class MainRepository  @Inject constructor( private val weatherApi: WeatherApi){
    suspend fun getWeatherResponse( cityName : String , appKey : String ) = weatherApi.getWeatherResponse(cityName, appKey)
}