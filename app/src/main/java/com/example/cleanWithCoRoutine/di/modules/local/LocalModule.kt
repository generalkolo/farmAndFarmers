package com.example.cleanWithCoRoutine.di.modules.local

import com.example.cleanWithCoRoutine.data.local.ICountryLocal
import com.example.cleanWithCoRoutine.data.local.ISharedPreferencesLocal
import com.example.cleanWithCoRoutine.local.impl.CountryLocal
import com.example.cleanWithCoRoutine.local.impl.SharedPreferencesLocal
import dagger.Binds
import dagger.Module

@Module(includes = [SharedPreferencesModule::class, RoomModule::class])
abstract class LocalModule {

    @Binds
    internal abstract fun bindCountryLocal( countryLocal: CountryLocal): ICountryLocal

    @Binds
    internal abstract fun bindSharedPreferencesLocal( sharedPreferencesLocal: SharedPreferencesLocal): ISharedPreferencesLocal

}