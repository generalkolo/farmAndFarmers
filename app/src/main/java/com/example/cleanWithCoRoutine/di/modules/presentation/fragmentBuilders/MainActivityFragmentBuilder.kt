package com.example.cleanWithCoRoutine.di.modules.presentation.fragmentBuilders

import com.example.cleanWithCoRoutine.di.FragmentScope
import com.example.cleanWithCoRoutine.ui.dashboard.DashboardFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityFragmentBuilder {

    @FragmentScope
    @ContributesAndroidInjector()
    abstract fun provideDashboardFragment(): DashboardFragment

}