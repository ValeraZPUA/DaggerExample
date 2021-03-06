package com.procreation.daggerexample.view.fragments.networkModuleFragment

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.procreation.daggerexample.App
import com.procreation.daggerexample.api.RequestsApi
import com.procreation.daggerexample.api.responseObjects.EventModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


@InjectViewState
class NetworkModuleFragmentPresenter : MvpPresenter<NetworkModuleFragmentView>() {

    @Inject
    lateinit var requestsApi: RequestsApi

    init {
        App.appComponent.inject(this)
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