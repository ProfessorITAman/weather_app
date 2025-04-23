package com.example.loading_app.Repository

import com.example.loading_app.Model.Core.Models.Service.RetroFitClient
import retrofit2.Retrofit

class WeatherRepository {

    suspend fun getWeather(
        location: String
    ) = RetroFitClient.retrofitService.getCurrentWeather(
            apiKey = "8addd2cf419f4a1a9e663340251304",
            city = location
        )
    }

