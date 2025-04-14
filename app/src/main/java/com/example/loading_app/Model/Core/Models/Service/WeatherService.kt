package com.example.loading_app.Model.Core.Models.Service

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("current.json")
    suspend fun getCurrentWeather(
        @Query("key") apiKey: String,
        @Query("q") city: String
    ): WeatherResponse
}
