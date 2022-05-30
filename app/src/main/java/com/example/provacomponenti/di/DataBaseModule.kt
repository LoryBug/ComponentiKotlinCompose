package com.example.provacomponenti.di

import com.example.provacomponenti.Database.MotorTracksDatabase
import dagger.hilt.InstallIn

import android.content.Context
import androidx.room.Room
import com.example.provacomponenti.Database.MotorDAO
import com.example.provacomponenti.Database.TrackDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    fun provideMotorDao(motorTracksDatabase: MotorTracksDatabase): MotorDAO {

        return motorTracksDatabase.motorDao()
    }
    @Provides
    fun provideTrackDao(motorTracksDatabase: MotorTracksDatabase): TrackDAO {

        return motorTracksDatabase.trackDao()
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): MotorTracksDatabase {
        return Room.databaseBuilder(
            appContext as BaseApplication,
            MotorTracksDatabase::class.java,
            "motortrack_db"
        ).build()
    }
}