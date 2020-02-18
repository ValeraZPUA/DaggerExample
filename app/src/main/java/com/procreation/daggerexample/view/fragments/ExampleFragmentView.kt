package com.procreation.daggerexample.view.fragments

import com.arellomobile.mvp.MvpView
import com.procreation.daggerexample.models.EventModel


interface ExampleFragmentView : MvpView {
    fun showToast(message: String)
    fun setList(list: List<EventModel>?)
}