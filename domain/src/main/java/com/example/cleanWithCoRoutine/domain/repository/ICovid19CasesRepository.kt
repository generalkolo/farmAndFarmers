package com.example.cleanWithCoRoutine.domain.repository

import com.example.cleanWithCoRoutine.domain.models.CountryDomainModel
import kotlinx.coroutines.flow.Flow

interface ICovid19CasesRepository {

    suspend fun insertCountries(countries: List<CountryDomainModel>)

    suspend fun getCountries(): Flow<List<CountryDomainModel>>

}