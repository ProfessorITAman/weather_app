package com.example.loading_app.Model.Core.Models.Service

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

object RetroFitClient {
    val name = "MyRetrofitClient"
    //https://api.weatherapi.com/v1/current.json?key=8addd2cf419f4a1a9e663340251304&q=Bishkek
    ///BASE URL https://api.weatherapi.com/v1/
    // endpoint == current.json
    // ? == query params
    //https://api.weatherapi.com/v1/current.json?key=8addd2cf419f4a1a9e663340251304&q=Bishkek

    private const val BASE_URL = "https://api.weatherapi.com/v1/"

    // интресептор это посредник между запросом и ответом
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY // это означает что будет все
    }
    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }
    val retrofitService: WeatherService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(WeatherService::class.java)
    }
}