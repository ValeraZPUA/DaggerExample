package com.procreation.daggerexample.utils

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(private val preferencesHelper: PreferencesHelper) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        if (request.header("Need-Authentication") != null) {
            val token = preferencesHelper.getToken()
            if (!token.isNullOrEmpty()) {
                val authRequest = request.newBuilder()
                    .header("api_token", token)
                    .build()
                return chain.proceed(authRequest)
            }
        }
        return chain.proceed(request)
    }
}