package com.example.cleanWithCoRoutine.di

import com.example.cleanWithCoRoutine.Application
import com.example.cleanWithCoRoutine.di.modules.AppModule
import com.example.cleanWithCoRoutine.di.modules.domain.DomainModule
import com.example.cleanWithCoRoutine.di.modules.local.LocalModule
import com.example.cleanWithCoRoutine.di.modules.presentation.ActivityBuilderModule
import com.example.cleanWithCoRoutine.di.modules.presentation.ViewModelModule
import com.example.cleanWithCoRoutine.di.modules.repository.RepositoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * Core Application Dagger Component
 */
@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        LocalModule::class,
        RepositoryModule::class,
        DomainModule::class,
        ActivityBuilderModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent: AndroidInjector<Application> {

    /**
     * A {@see [Component.Builder]} that initializes necessary implementations
     */
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application : Application) : Builder
        fun build() : AppComponent
    }

}

