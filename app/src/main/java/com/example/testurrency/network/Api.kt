package com.example.testurrency.network

import com.example.testurrency.data.Valute
import com.example.testurrency.data.Wrapper
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("daily_json.js")
    suspend fun getValuteValues(): Wrapper<Valute>
}