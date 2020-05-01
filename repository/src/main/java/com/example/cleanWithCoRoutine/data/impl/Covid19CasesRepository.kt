package com.example.cleanWithCoRoutine.data.impl

import com.example.cleanWithCoRoutine.data.local.ICountryLocal
import com.example.cleanWithCoRoutine.data.mappers.toDomain
import com.example.cleanWithCoRoutine.data.mappers.toEntity
import com.example.cleanWithCoRoutine.domain.models.CountryDomainModel
import com.example.cleanWithCoRoutine.domain.repository.ICovid19CasesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class Covid19CasesRepository @Inject constructor(
    private val countryLocal: ICountryLocal
) : ICovid19CasesRepository {
    override suspend fun insertCountries(countries: List<CountryDomainModel>) =
        countryLocal.insertCountries(countries.map {
            it.toEntity()
        })

    override suspend fun getCountries(): Flow<List<CountryDomainModel>> =
        countryLocal.getCountries().map { resp ->
            resp.map {
                it.toDomain()
            }
        }
}