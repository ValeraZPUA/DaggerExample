package com.procreation.daggerexample.view.fragments.preferencesModuleFragment

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.procreation.daggerexample.App
import com.procreation.daggerexample.utils.PreferencesHelper
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@InjectViewState
class PreferencesModuleFragmentPresenter : MvpPresenter<PreferencesModuleFragmentView>() {

    lateinit var result: Disposable

    @Inject
    lateinit var preferencesHelper: PreferencesHelper

    init {
        App.appComponent.inject(this)
    }

    fun saveData(string: String) {
        result = Observable.just(string)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                preferencesHelper.saveData(it)
                viewState.showToast("saved")
                result.dispose()
            }, {
                viewState.showToast("Some thing went wrong")
                result.dispose()
            })

    }

    fun loadData() {
        result = Observable.just(preferencesHelper.loadData())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.showToast("loaded")
                viewState.setTextView(it)
                result.dispose()
            }, {
                viewState.showToast("Some thing went wrong")
                result.dispose()
            })
    }
}