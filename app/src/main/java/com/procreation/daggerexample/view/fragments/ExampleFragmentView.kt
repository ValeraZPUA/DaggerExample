package com.procreation.daggerexample.view.fragments

import com.arellomobile.mvp.MvpView


interface ExampleFragmentView : MvpView {
    fun showToast(message: String)
}