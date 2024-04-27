package com.example.myapplicationpractice

data class LoginResponse(
    var id : Int,
    var username : String,
    var email : String,
    var firstName : String,
    var lastName : String,
    var gender : String,
    var image : String,
    var token : String
)