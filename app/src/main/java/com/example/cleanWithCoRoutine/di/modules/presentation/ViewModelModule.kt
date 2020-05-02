package com.example.cleanWithCoRoutine.di.modules.presentation

import androidx.lifecycle.ViewModelProvider
import com.example.cleanWithCoRoutine.di.factory.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}