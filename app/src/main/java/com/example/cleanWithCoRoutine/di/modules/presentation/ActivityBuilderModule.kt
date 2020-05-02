package com.example.cleanWithCoRoutine.di.modules.presentation

import com.example.cleanWithCoRoutine.di.ActivityScope
import com.example.cleanWithCoRoutine.di.modules.presentation.fragmentBuilders.MainActivityFragmentBuilder
import com.example.cleanWithCoRoutine.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityFragmentBuilder::class])
    internal abstract fun provideMainActivity(): MainActivity

}