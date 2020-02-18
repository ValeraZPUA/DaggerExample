package com.procreation.daggerexample.view.fragments

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.procreation.daggerexample.App
import com.procreation.daggerexample.api.RequestsApi
import com.procreation.daggerexample.models.EventModel
import com.procreation.daggerexample.utils.PreferencesHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


@InjectViewState
class ExampleFragmentPresenter : MvpPresenter<ExampleFragmentView>() {

    @Inject
    lateinit var preferencesHelper: PreferencesHelper
    @Inject
    lateinit var requestsApi: RequestsApi

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

    fun getData() {
        requestsApi.getData().enqueue(object : Callback<List<EventModel>?> {
            override fun onFailure(call: Call<List<EventModel>?>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<EventModel>?>, response: Response<List<EventModel>?>) {
                viewState.setList(response.body())
            }

        })
    }

}