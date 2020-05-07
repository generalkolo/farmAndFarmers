package com.example.cleanWithCoRoutine.di.modules.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanWithCoRoutine.auth.presentation.AuthActivityViewModel
import com.example.cleanWithCoRoutine.di.ViewModelKey
import com.example.cleanWithCoRoutine.di.factory.ViewModelFactory
import com.example.cleanWithCoRoutine.statistics.presentation.StatisticActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @IntoMap
    @Binds
    @ViewModelKey(AuthActivityViewModel::class)
    abstract fun bindAuthBViewModel(authActivityViewModel: AuthActivityViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(StatisticActivityViewModel::class)
    abstract fun bindStatisticsViewModel(statisticActivityViewModel: StatisticActivityViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}