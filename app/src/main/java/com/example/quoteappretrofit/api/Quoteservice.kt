package com.example.quoteappretrofit.api

import com.example.quoteappretrofit.models.Quote
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Quoteservice {

    @GET("/quotes")
    fun getQuote(@Query("page") page : Int) : Call<Quote>
}