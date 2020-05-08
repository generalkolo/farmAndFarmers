package com.example.cleanWithCoRoutine

import com.example.cleanWithCoRoutine.di.AppComponent
import com.example.cleanWithCoRoutine.di.DaggerAppComponent
import com.facebook.drawee.backends.pipeline.Fresco
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

open class Application : DaggerApplication(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    lateinit var appInjector: AndroidInjector<out DaggerApplication>

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        // Initialize the Fresco class
        Fresco.initialize(this)
//        appComponent = DaggerAppComponent.factory().create(applicationContext)
//
//        getApplicationComponent().inject(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

        appComponent = DaggerAppComponent.builder().application(this).build()
        appComponent.inject(this)

        return appComponent
    }

    open fun getApplicationComponent(): AppComponent = appComponent

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

}