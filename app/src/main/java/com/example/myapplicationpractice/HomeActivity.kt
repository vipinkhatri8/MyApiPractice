package com.example.myapplicationpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.myapplicationpractice.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    private lateinit var loginViewModel : LoginViewModel
    private  lateinit var  sessionManagement: SessionManagement
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        sessionManagement =  SessionManagement(this)


        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        val token = intent.getStringExtra("token")
token?.let {
    loginViewModel.getDetail(it).observe(this, Observer { logindata ->

        logindata.let {
            binding.username.text = logindata.username
            binding.firstname.text = logindata.firstName
            binding.lastname.text = logindata.lastName
            binding.email.text = logindata.email
            binding.gender.text = logindata.gender

            Glide.with(this).load(logindata.image).into(binding.image)
        }
    })

}
    binding.textSubmitButton.setOnClickListener {
        sessionManagement.logOut()
        var intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
}
    }
}