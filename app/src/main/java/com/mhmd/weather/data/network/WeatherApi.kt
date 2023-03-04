package com.mhmd.weather.data.network

import com.mhmd.weather.domain.models.model.WeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("data/2.5/forecast")
    suspend fun getWeatherResponse(
        @Query("q") cityName   : String,
        @Query("appid") appKey : String
    ): Response<WeResponse>
}