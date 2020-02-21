package com.procreation.daggerexample.view.fragments.preferencesModuleFragment

import com.arellomobile.mvp.MvpView

interface PreferencesModuleFragmentView : MvpView {
    fun showToast(message: String)
}