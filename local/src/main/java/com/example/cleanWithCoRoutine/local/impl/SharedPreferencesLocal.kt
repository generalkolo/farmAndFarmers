package com.example.cleanWithCoRoutine.local.impl

import com.example.cleanWithCoRoutine.data.local.ISharedPreferencesLocal
import com.example.cleanWithCoRoutine.local.preference.Covid19CompanionSharedPreferences
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SharedPreferencesLocal @Inject constructor(
    private val covid19CompanionSharedPreferences: Covid19CompanionSharedPreferences
): ISharedPreferencesLocal {

    override suspend fun getNumberOfTries(): Flow<Int> =
        covid19CompanionSharedPreferences.getNumberOfCheck()

}