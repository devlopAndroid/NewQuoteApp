package com.example.quoteappretrofit.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofithelper {

    val Base_Url = "https://quotable.io"

    fun getInstance() : Retrofit{
        return Retrofit.Builder().baseUrl(Base_Url)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}