package com.mhmd.weather.di

import android.app.Application
import androidx.room.Room
import com.mhmd.weather.data.database.WeatherDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {
    @Singleton
    @Provides
    fun provideWeatherDatabase(app : Application) : WeatherDatabase =
        Room.databaseBuilder(app , WeatherDatabase::class.java , "weatherq.db")
            .fallbackToDestructiveMigration().build()
}