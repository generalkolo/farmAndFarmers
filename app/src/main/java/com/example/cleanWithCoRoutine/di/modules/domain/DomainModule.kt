package com.example.cleanWithCoRoutine.di.modules.domain

import com.example.cleanWithCoRoutine.data.impl.Covid19CasesRepository
import com.example.cleanWithCoRoutine.data.impl.SharedPreferencesRepository
import com.example.cleanWithCoRoutine.domain.usecases.GetCountriesUseCase
import com.example.cleanWithCoRoutine.domain.usecases.GetNumberOfTriesUseCase
import com.example.cleanWithCoRoutine.domain.usecases.InsertCountriesUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetCountriesUseCase(
        covid19CasesRepository: Covid19CasesRepository
    ): GetCountriesUseCase = GetCountriesUseCase(covid19CasesRepository)

    @Provides
    fun provideInsertCountriesUseCase(
        covid19CasesRepository: Covid19CasesRepository
    ): InsertCountriesUseCase = InsertCountriesUseCase(covid19CasesRepository)

    @Provides
    fun provideSharedPreferencesUseCase(
        sharedPreferencesRepository: SharedPreferencesRepository
    ): GetNumberOfTriesUseCase = GetNumberOfTriesUseCase(sharedPreferencesRepository)

}