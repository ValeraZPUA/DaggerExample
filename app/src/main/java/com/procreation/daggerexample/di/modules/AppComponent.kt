package com.procreation.daggerexample.di.modules

import com.procreation.daggerexample.view.fragments.ExampleFragment
import com.procreation.daggerexample.view.fragments.ExampleFragmentPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ContextModule::class,
        PreferencesModule::class
    ]
)

interface AppComponent {
    fun inject(exampleFragmentPresenter: ExampleFragmentPresenter)
    fun inject(exampleFragment: ExampleFragment)
}