package com.mhmd.weather.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity( tableName  = "weatherInformation")
data class WeatherTable(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var json: String ? = null
)

