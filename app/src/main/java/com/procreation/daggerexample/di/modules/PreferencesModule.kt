package com.procreation.daggerexample.di.modules

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PreferencesModule(private var preferencesName: String) {

    @Singleton
    @Provides
    fun sharedPreferences(context: Context) : SharedPreferences {
        return context.getSharedPreferences(preferencesName, Context.MODE_PRIVATE)
    }

}