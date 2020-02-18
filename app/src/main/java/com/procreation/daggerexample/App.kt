package com.procreation.daggerexample

import android.app.Application
import android.util.Log
import com.procreation.daggerexample.di.modules.AppComponent
import com.procreation.daggerexample.di.modules.ContextModule
import com.procreation.daggerexample.di.modules.DaggerAppComponent
import com.procreation.daggerexample.di.modules.PreferencesModule

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        Log.d("tag", "App")

        appComponent = DaggerAppComponent.builder()
            .contextModule(ContextModule(this))
            .preferencesModule(PreferencesModule(Constants.PREFERENCES_NAME))
            .build()


    }
}