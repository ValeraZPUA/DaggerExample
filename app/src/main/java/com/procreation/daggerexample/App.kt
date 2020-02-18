package com.procreation.daggerexample

import android.app.Application
import com.procreation.daggerexample.di.AppComponent
import com.procreation.daggerexample.di.DaggerAppComponent
import com.procreation.daggerexample.di.modules.ContextModule
import com.procreation.daggerexample.di.modules.NetworkModule
import com.procreation.daggerexample.di.modules.PreferencesModule

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .contextModule(ContextModule(this))
            .preferencesModule(PreferencesModule(Constants.PREFERENCES_NAME))
            .networkModule(NetworkModule(Constants.BASE_URL))
            .build()
    }
}