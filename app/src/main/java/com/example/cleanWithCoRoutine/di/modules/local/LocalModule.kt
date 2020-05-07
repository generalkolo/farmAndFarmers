package com.example.cleanWithCoRoutine.di.modules.local

import com.example.cleanWithCoRoutine.data.local.ICountryLocal
import com.example.cleanWithCoRoutine.data.local.auth.UserLocal
import com.example.cleanWithCoRoutine.data.local.statistics.StatisticsLocal
import com.example.cleanWithCoRoutine.local.impl.CountryLocal
import com.example.cleanWithCoRoutine.local.impl.auth.UserLocalImpl
import com.example.cleanWithCoRoutine.local.impl.statistics.StatisticsLocalImpl
import dagger.Binds
import dagger.Module

@Module(includes = [RoomModule::class])
abstract class LocalModule {

    @Binds
    internal abstract fun bindCountryLocal(countryLocal: CountryLocal): ICountryLocal

    @Binds
    internal abstract fun bindStatisticsLocal(statisticsLocalImpl: StatisticsLocalImpl): StatisticsLocal

    @Binds
    internal abstract fun authLocal(userLocalImpl: UserLocalImpl): UserLocal
}