package com.example.loading_app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loading_app.Model.Core.Models.Service.RetroFitClient
import com.example.loading_app.Model.Core.Models.Service.Tudasuda

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val client = RetroFitClient
        println(RetroFitClient.name)
        }
    fun calculate(a: Int , b: Int){

    }
}

