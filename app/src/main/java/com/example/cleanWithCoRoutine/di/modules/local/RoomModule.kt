package com.example.cleanWithCoRoutine.di.modules.local

import android.content.Context
import com.example.cleanWithCoRoutine.local.room.AppDatabase
import com.example.cleanWithCoRoutine.local.room.dao.FarmAndFarmDetailsDao
import com.example.cleanWithCoRoutine.local.room.dao.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class RoomModule {

    @Provides
    fun provideDatabase(@Named("AppContext") application: Context) = AppDatabase.invoke(application)

    @Provides
    fun provideFarmAndFarmDetailsDao(database: AppDatabase): FarmAndFarmDetailsDao =
        database.getFarmAndFarmDetailsDao()

    @Provides
    fun provideUserDao(database: AppDatabase): UserDao =
        database.getUserDao()

}