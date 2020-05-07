package com.example.cleanWithCoRoutine.di.modules.presentation

import com.example.cleanWithCoRoutine.auth.presentation.AuthActivity
import com.example.cleanWithCoRoutine.di.ActivityScope
import com.example.cleanWithCoRoutine.di.modules.presentation.fragmentBuilders.AuthActivityFragmentBuilder
import com.example.cleanWithCoRoutine.di.modules.presentation.fragmentBuilders.StatisticsFragmentBuilder
import com.example.cleanWithCoRoutine.statistics.presentation.StatisticsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilderModule {

//    @ActivityScope
////    @ContributesAndroidInjector(modules = [MainActivityFragmentBuilder::class])
//    @ContributesAndroidInjector()
//    internal abstract fun provideMainActivity(): AppActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [AuthActivityFragmentBuilder::class])
    internal abstract fun provideAuthActivity(): AuthActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [StatisticsFragmentBuilder::class])
    internal abstract fun provideStatisticsActivity(): StatisticsActivity


}