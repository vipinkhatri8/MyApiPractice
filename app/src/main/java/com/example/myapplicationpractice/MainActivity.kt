package com.example.myapplicationpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplicationpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var  binding: ActivityMainBinding
    var loginViewModel = LoginViewModel()
    private  lateinit var sessionManagement: SessionManagement
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        sessionManagement = SessionManagement(this)

        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)



        binding.textSubmitButton.setOnClickListener {
            val username = binding.username.text.toString().trim()
            val password = binding.password.text.toString().trim()
            loginViewModel.login(username, password).observe(this, Observer {loginData->

                if (loginData != null){
                    val (token, loginresponse) = loginData
                    val  intent = Intent(this, HomeActivity::class.java)
                     intent.putExtra("token",token)
                    startActivity(intent)
                    sessionManagement.isLogin(loginresponse)
                }

            })

        }



    }
}