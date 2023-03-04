package com.mhmd.weather.data.database

import androidx.room.*
import com.mhmd.weather.data.local.WeatherTable
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {

    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    suspend fun upsertWeather(weather : WeatherTable)

    @Query("SELECT * FROM weatherInformation")
   suspend fun getDataFromLocal() : List<WeatherTable>

}