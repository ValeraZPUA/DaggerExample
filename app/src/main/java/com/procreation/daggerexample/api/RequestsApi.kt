package com.procreation.daggerexample.api

import com.procreation.daggerexample.api.responseObjects.EventModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface RequestsApi {

    @GET("comingEvents")
    //@Headers("Need-Authentication: true") if need auth to put token
    fun getData(): Call<List<EventModel>?>

}