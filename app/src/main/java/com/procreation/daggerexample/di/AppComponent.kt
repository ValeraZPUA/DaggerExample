package com.procreation.daggerexample.di

import com.procreation.daggerexample.di.modules.ContextModule
import com.procreation.daggerexample.di.modules.NetworkModule
import com.procreation.daggerexample.di.modules.PreferencesModule
import com.procreation.daggerexample.view.fragments.exampleFragment.ExampleFragment
import com.procreation.daggerexample.view.fragments.exampleFragment.ExampleFragmentPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ContextModule::class,
        PreferencesModule::class,
        NetworkModule::class
    ]
)

interface AppComponent {
    fun inject(exampleFragmentPresenter: ExampleFragmentPresenter)
    fun inject(exampleFragment: ExampleFragment)
}