package com.procreation.daggerexample.view.fragments.exampleFragment

import com.arellomobile.mvp.MvpView
import com.procreation.daggerexample.api.responseObjects.EventModel


interface ExampleFragmentView : MvpView {
    fun showToast(message: String)
    fun setList(list: List<EventModel>?)
}