package com.example.myapplicationpractice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitClass {
    var retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://dummyjson.com/")
        .build()
    var apiInterface = retrofit.create(ApiInterface::class.java)



}