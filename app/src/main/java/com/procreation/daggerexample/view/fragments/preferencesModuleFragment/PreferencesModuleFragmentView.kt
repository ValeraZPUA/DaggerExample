package com.procreation.daggerexample.view.fragments.preferencesModuleFragment

import com.arellomobile.mvp.MvpView
import com.procreation.daggerexample.api.responseObjects.EventModel


interface PreferencesModuleFragmentView : MvpView {
    fun showToast(message: String)
    fun setList(list: List<EventModel>?)
}