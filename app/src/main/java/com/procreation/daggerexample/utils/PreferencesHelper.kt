package com.procreation.daggerexample.utils

import android.content.SharedPreferences
import com.procreation.daggerexample.Constants
import javax.inject.Inject

class PreferencesHelper @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {
    fun saveData(string: String) {
        sharedPreferences.edit().putString(Constants.STRING_VALUE, string).apply()
    }

    fun loadData(): String? {
        return sharedPreferences.getString(Constants.STRING_VALUE,"")
    }
}