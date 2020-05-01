package com.example.cleanWithCoRoutine.domain.repository

import kotlinx.coroutines.flow.Flow

interface ISharedPreferencesRepository {

    suspend fun getNumberOfTries(): Flow<Int>

}