package com.example.cleanWithCoRoutine.di.modules.repository

import com.example.cleanWithCoRoutine.data.impl.Covid19CasesRepository
import com.example.cleanWithCoRoutine.data.impl.SharedPreferencesRepository
import com.example.cleanWithCoRoutine.data.impl.auth.AuthRepositoryImpl
import com.example.cleanWithCoRoutine.data.impl.statistics.StatisticsRepositoryImpl
import com.example.cleanWithCoRoutine.domain.repository.ICovid19CasesRepository
import com.example.cleanWithCoRoutine.domain.repository.ISharedPreferencesRepository
import com.example.cleanWithCoRoutine.domain.repository.auth.AuthRepository
import com.example.cleanWithCoRoutine.domain.repository.statistics.StatisticsRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindCovid19CasesRepository(
        covid19CasesRepository: Covid19CasesRepository
    ): ICovid19CasesRepository

    @Singleton
    @Binds
    abstract fun bindSharedPreferencesRepository(
        sharedPreferencesRepository: SharedPreferencesRepository
    ): ISharedPreferencesRepository

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