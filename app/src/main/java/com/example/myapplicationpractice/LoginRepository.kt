package com.example.myapplicationpractice

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepository {
    val apiservice = RetrofitClass.apiInterface
    fun login(username : String, password : String) : LiveData<Pair<String, LoginResponse>?> {
        val userLiveData = MutableLiveData<Pair<String,LoginResponse>?>()
        apiservice.getLogin(username, password).enqueue(object : Callback<JsonObject>{
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
               if (response.isSuccessful){
                   val jsonObject = response.body()
                   if (jsonObject != null){
                      try {
                          val  gson = Gson()
                          val loginResponse = gson.fromJson(jsonObject, LoginResponse::class.java)
                          val token = loginResponse.token
                          val id = loginResponse.id

                          Log.d("id15",id.toString())


                          userLiveData.value = Pair(token, loginResponse)
                      }
                      catch (e : Exception){
                          Log.e("Login", "Gson parsing exception: ${e.message}")
                          userLiveData.value = null // or handle error state accordingly
                      }
                   }
               }
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return  userLiveData
    }


    fun getLogin(token: String) : LiveData<LoginResponse>{
        val getLiveData = MutableLiveData<LoginResponse>()
        apiservice.getDetail(token).enqueue(object : Callback<JsonObject>{
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                if (response.isSuccessful){
                val  jsonObject = response.body()
                if (jsonObject != null){
                    val gson = Gson()
                    val loginresponse = gson.fromJson(jsonObject, LoginResponse::class.java)
                    getLiveData.value = loginresponse
                }
            }}

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

        return getLiveData
    }







}