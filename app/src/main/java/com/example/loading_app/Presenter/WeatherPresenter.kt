package com.example.loading_app.Presenter

import android.util.Log
import com.example.loading_app.Repository.WeatherRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class WeatherPresenter(
    private var view: WeatherContract.View?
): WeatherContract.Presenter{
    private val repository = WeatherRepository()
    private val job = Job()
    private val scope = CoroutineScope(Dispatchers.Main +  job)

    override fun loadWeather(location: String) {
        scope.launch {
            try {
                val weather = repository.getWeather(location)
                view?.showWeather(weather)
            }catch (e: Exception){
                Log.e("ololo", e.message.toString())
                view?.showError(e.message ?: "Unknown error")
            }
        }
    }

    override fun onDestroy() {
        view = null
        job.cancel()
    }
}