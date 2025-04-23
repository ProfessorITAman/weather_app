package com.example.loading_app.Presenter

import android.os.Message
import com.example.loading_app.Model.Core.Models.Service.WeatherResponse

interface WeatherContract {

    interface View {
        fun showWeather(weather: WeatherResponse)
        fun showError(message: String)

    }

    interface Presenter {
        fun loadWeather(location: String)
        fun onDestroy()
    }
}