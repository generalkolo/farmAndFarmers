package com.example.cleanWithCoRoutine.local.preference

import android.content.Context
import com.example.cleanWithCoRoutine.local.utils.COVID_19_COMPANION_SHARED_PREFERENCES
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Covid19CompanionSharedPreferences constructor(
    context: Context
) {

    private val covid19CompanionAppSharedPref = context.getSharedPreferences(
        COVID_19_COMPANION_SHARED_PREFERENCES, Context.MODE_PRIVATE
    )

    suspend fun getNumberOfCheck(): Flow<Int> {
        var numberOfChecks = covid19CompanionAppSharedPref.getInt("KEY", 1)
        covid19CompanionAppSharedPref.edit().also {
            it.putInt("KEY", ++numberOfChecks)
        }.apply()

        return flow { emit(numberOfChecks) }
    }
}