package com.example.cleanWithCoRoutine.di.modules.local

import android.content.Context
import com.example.cleanWithCoRoutine.local.preference.Covid19CompanionSharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class SharedPreferencesModule {

    @Provides
    fun provideSharedPreferences(@Named("AppContext") applicationContext: Context) = Covid19CompanionSharedPreferences(applicationContext)

}