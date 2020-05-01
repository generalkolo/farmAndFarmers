package com.example.cleanWithCoRoutine.di.modules

import android.content.Context
import com.example.cleanWithCoRoutine.Application
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule{

    @Singleton
    @Provides
    @Named("AppContext")
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

}