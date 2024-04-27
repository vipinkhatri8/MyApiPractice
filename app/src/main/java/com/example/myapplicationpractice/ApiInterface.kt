package com.example.myapplicationpractice

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterface {

    @FormUrlEncoded
@POST("auth/login")
fun  getLogin(@Field("username") username : String,
    @Field("password") password : String) : Call<JsonObject>


@POST("auth/refresh")
 fun getDetail(@Header("Authorization") token : String) : Call<JsonObject>

}