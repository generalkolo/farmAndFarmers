package com.example.cleanWithCoRoutine.data.local

import kotlinx.coroutines.flow.Flow

interface ISharedPreferencesLocal {

    suspend fun getNumberOfTries(): Flow<Int>

}