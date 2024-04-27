package com.example.myapplicationpractice

import android.content.Context
import android.content.SharedPreferences

class SessionManagement(context: Context) {
    private val sharedPreferences : SharedPreferences
    private val editor :  SharedPreferences.Editor
    private var LOGIN= "login"
    private var key= "key"


    init {
        sharedPreferences = context.getSharedPreferences(LOGIN, Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
    }

    fun  isLogin(user: LoginResponse){
        val id = user.id
        editor.putString(key, id.toString()).apply()
    }

    fun getSession() : String? {
        return  sharedPreferences.getString(key,null)
    }

    fun logOut(){
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }



}