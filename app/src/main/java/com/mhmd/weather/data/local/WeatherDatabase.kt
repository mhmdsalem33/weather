package com.mhmd.weather.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mhmd.weather.data.local.WeatherTable


@Database(entities = [WeatherTable::class] , version = 1)
abstract class WeatherDatabase() : RoomDatabase() {
    abstract fun weatherDao() : WeatherDao
}