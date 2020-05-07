package com.example.cleanWithCoRoutine.di.modules.repository

import com.example.cleanWithCoRoutine.data.impl.auth.AuthRepositoryImpl
import com.example.cleanWithCoRoutine.data.impl.statistics.StatisticsRepositoryImpl
import com.example.cleanWithCoRoutine.domain.repository.auth.AuthRepository
import com.example.cleanWithCoRoutine.domain.repository.statistics.StatisticsRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindFarmAndFarmDetailsRepository(
        statisticsRepositoryImpl: StatisticsRepositoryImpl
    ): StatisticsRepository

    @Singleton
    @Binds
    abstract fun bindUserRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

}