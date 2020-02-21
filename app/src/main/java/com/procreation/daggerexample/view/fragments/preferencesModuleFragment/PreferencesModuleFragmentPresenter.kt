package com.procreation.daggerexample.view.fragments.preferencesModuleFragment

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.procreation.daggerexample.App
import com.procreation.daggerexample.utils.PreferencesHelper
import javax.inject.Inject

@InjectViewState
class PreferencesModuleFragmentPresenter : MvpPresenter<PreferencesModuleFragmentView>() {

    @Inject
    lateinit var preferencesHelper: PreferencesHelper

    init {
        App.appComponent.inject(this)
    }

    fun saveData(string: String) {
        preferencesHelper.saveData(string)
        viewState.showToast("saved")
    }

    fun loadData(): String? {
        viewState.showToast("loaded")
        return preferencesHelper.loadData()
    }
}