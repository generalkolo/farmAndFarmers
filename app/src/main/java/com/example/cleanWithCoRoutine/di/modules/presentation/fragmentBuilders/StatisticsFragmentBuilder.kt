package com.example.cleanWithCoRoutine.di.modules.presentation.fragmentBuilders

import com.example.cleanWithCoRoutine.di.FragmentScope
import com.example.cleanWithCoRoutine.statistics.presentation.fragments.*
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class StatisticsFragmentBuilder {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindDashboardFragment(): DashboardFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindFarmDetailsFragment(): FarmDetailsFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindFarmerDetailsFragment(): FarmerDetailsFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindClickedDetailsFragment(): ClickedFarmDetailsFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindDetailsContainerFragment(): DetailsContainerFragment
}