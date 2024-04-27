package com.example.myapplicationpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import com.example.myapplicationpractice.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    lateinit var binding: ActivitySplashBinding
    private lateinit var sessionManagement :SessionManagement
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        sessionManagement = SessionManagement(this)




        Handler().postDelayed({
            val id = sessionManagement.getSession()
            Log.d("id15", id.toString())
            if (id != null){
                var intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
            else{
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }




        }, 3000)


    }
}