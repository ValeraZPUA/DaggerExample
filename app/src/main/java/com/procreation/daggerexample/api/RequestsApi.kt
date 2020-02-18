package com.procreation.daggerexample.api

import com.procreation.daggerexample.models.EventModel
import retrofit2.Call
import retrofit2.http.GET

interface RequestsApi {

    @GET("comingEvents")
    fun getData(): Call<List<EventModel>?>

}