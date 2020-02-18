package com.procreation.daggerexample.view.activities

import android.view.View
import com.arellomobile.mvp.MvpView

interface MainActivityView : MvpView {
    //fun onFragment1NextClick(view: View)
    fun test(s: String)
}