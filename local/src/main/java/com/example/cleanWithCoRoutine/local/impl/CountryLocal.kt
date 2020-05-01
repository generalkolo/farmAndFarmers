package com.example.cleanWithCoRoutine.local.impl

import com.example.cleanWithCoRoutine.data.local.ICountryLocal
import com.example.cleanWithCoRoutine.data.models.CountryEntityModel
import com.example.cleanWithCoRoutine.local.mappers.toEntity
import com.example.cleanWithCoRoutine.local.mappers.toLocal
import com.example.cleanWithCoRoutine.local.room.dao.CountryDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CountryLocal @Inject constructor(
    private val countryDao: CountryDao
) : ICountryLocal {
    override suspend fun insertCountries(countries: List<CountryEntityModel>) {
        countryDao.insertCountries(countries.map {
            it.toLocal()
        })
    }

    override suspend fun getCountries(): Flow<List<CountryEntityModel>> =
        flow {
            emit(countryDao.getAllCountries().map {
                it.toEntity()
            })
        }
}