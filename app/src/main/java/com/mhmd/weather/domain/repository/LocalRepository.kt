package com.mhmd.weather.domain.repository

import com.mhmd.weather.data.database.WeatherDatabase
import com.mhmd.weather.data.local.WeatherTable
import com.mhmd.weather.domain.models.model.WeResponse
import javax.inject.Inject

class LocalRepository @Inject constructor(private val db : WeatherDatabase) {
    private val localDao = db.weatherDao()
    suspend fun upsertWeather(weather : WeatherTable) = localDao.upsertWeather(weather)
    suspend fun  getDataFromLocal()   = localDao.getDataFromLocal()


}