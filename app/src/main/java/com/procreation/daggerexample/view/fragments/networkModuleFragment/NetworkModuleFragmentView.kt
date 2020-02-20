package com.procreation.daggerexample.view.fragments.networkModuleFragment

import com.arellomobile.mvp.MvpView
import com.procreation.daggerexample.api.responseObjects.EventModel


interface NetworkModuleFragmentView : MvpView {
    fun setList(list: List<EventModel>?)
}