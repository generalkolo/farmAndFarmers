package com.example.cleanWithCoRoutine.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import javax.inject.Scope
import kotlin.reflect.KClass

/**
 * Annotation for having custom keys for viewmodel factory map
 */
@MapKey
@Target(AnnotationTarget.FUNCTION)
annotation class ViewModelKey(val value: KClass<out ViewModel>)

/**
 * Scopes dependencies injected into activity to be preserved as long as the activity component is available
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope

/**
 * Scopes dependencies injected into fragment to be preserved as long as the fragment component is available
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FragmentScope
