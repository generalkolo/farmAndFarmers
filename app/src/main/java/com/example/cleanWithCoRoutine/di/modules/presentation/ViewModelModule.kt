package com.example.cleanWithCoRoutine.di.modules.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanWithCoRoutine.di.ViewModelKey
import com.example.cleanWithCoRoutine.di.factory.ViewModelFactory
import com.example.cleanWithCoRoutine.ui.dashboard.DashboardViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @IntoMap
    @Binds
    @ViewModelKey(DashboardViewModel::class)
    abstract fun bindCharacterSearchViewModel(dashboardViewModel: DashboardViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}