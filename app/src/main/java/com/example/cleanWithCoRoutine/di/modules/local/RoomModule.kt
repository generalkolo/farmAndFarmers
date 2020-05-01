package com.example.cleanWithCoRoutine.di.modules.local

import android.content.Context
import com.example.cleanWithCoRoutine.local.room.AppDatabase
import com.example.cleanWithCoRoutine.local.room.dao.CountryDao
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class RoomModule {

    @Provides
    fun provideDatabase(@Named("AppContext") application: Context) = AppDatabase.invoke(application)

    @Provides
    fun provideCountryDao(database: AppDatabase): CountryDao =
        database.getCountryDao()

}