package com.example.cleanWithCoRoutine.data.local

import com.example.cleanWithCoRoutine.data.models.CountryEntityModel
import kotlinx.coroutines.flow.Flow

interface ICountryLocal {

    suspend fun insertCountries(countries: List<CountryEntityModel>)

    suspend fun getCountries(): Flow<List<CountryEntityModel>>

}