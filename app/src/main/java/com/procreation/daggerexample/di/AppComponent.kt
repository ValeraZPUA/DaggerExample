package com.procreation.daggerexample.di

import com.procreation.daggerexample.di.modules.ContextModule
import com.procreation.daggerexample.di.modules.NetworkModule
import com.procreation.daggerexample.di.modules.PreferencesModule
import com.procreation.daggerexample.view.fragments.networkModuleFragment.NetworkModuleFragmentPresenter
import com.procreation.daggerexample.view.fragments.preferencesModuleFragment.PreferencesModuleFragment
import com.procreation.daggerexample.view.fragments.preferencesModuleFragment.PreferencesModuleFragmentPresenter
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
    fun inject(preferencesModuleFragmentPresenter: PreferencesModuleFragmentPresenter)
    fun inject(networkModuleFragmentPresenter: NetworkModuleFragmentPresenter)
    fun inject(preferencesModuleFragment: PreferencesModuleFragment)
}