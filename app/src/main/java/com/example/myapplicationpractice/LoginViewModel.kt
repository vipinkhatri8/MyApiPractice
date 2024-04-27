package com.example.myapplicationpractice

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel(){
    var loginRepository = LoginRepository()
    fun login(username : String, password: String) : LiveData<Pair<String,LoginResponse>?>{
        return  loginRepository.login(username, password)
    }

    fun getDetail(token: String) : LiveData<LoginResponse>{
        return  loginRepository.getLogin(token)
    }
}