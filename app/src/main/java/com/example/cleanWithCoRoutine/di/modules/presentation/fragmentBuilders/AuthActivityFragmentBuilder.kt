package com.example.cleanWithCoRoutine.di.modules.presentation.fragmentBuilders

import com.example.cleanWithCoRoutine.auth.presentation.fragments.LoginFragment
import com.example.cleanWithCoRoutine.di.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AuthActivityFragmentBuilder {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindLoginFragment(): LoginFragment

}