package com.procreation.daggerexample.view.fragments

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.procreation.daggerexample.App
import com.procreation.daggerexample.utils.PreferencesHelper
import javax.inject.Inject


@InjectViewState
class ExampleFragmentPresenter : MvpPresenter<ExampleFragmentView>() {

    @Inject
    lateinit var preferencesHelper: PreferencesHelper

    init {
        App.appComponent.inject(this)
    }

    fun saveData(string: String) {
        preferencesHelper.saveData(string)
    }

    fun loadData() : String? {
        return preferencesHelper.loadData()
    }

}