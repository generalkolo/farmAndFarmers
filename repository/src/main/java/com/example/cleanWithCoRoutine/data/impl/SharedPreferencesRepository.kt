package com.example.cleanWithCoRoutine.data.impl

import com.example.cleanWithCoRoutine.data.local.ISharedPreferencesLocal
import com.example.cleanWithCoRoutine.domain.repository.ISharedPreferencesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SharedPreferencesRepository @Inject constructor(
    private val sharedPreferencesLocal: ISharedPreferencesLocal
): ISharedPreferencesRepository {

    override suspend fun getNumberOfTries(): Flow<Int> =
        sharedPreferencesLocal.getNumberOfTries()

}