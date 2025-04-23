package com.example.loading_app

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loading_app.Model.Core.Models.Service.RetroFitClient
import com.example.loading_app.Model.Core.Models.Service.WeatherResponse
import com.example.loading_app.Presenter.WeatherContract
import com.example.loading_app.Presenter.WeatherPresenter
import com.example.loading_app.databinding.ActivityMainBinding
import kotlinx.serialization.descriptors.StructureKind
import kotlin.text.toInt
import kotlin.toString

class MainActivity : AppCompatActivity(), WeatherContract.View {

    private lateinit var binding : ActivityMainBinding
    private val presenter by lazy { WeatherPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter.loadWeather("London")
        initialize()

    }
    private fun initialize() = with(binding) {
        ArrayAdapter.createFromResource(
            root.context,
            R.array.country_list,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            countries.adapter = adapter
        }

        countries.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedItem = parent.getItemAtPosition(position).toString()
                presenter.loadWeather(selectedItem)
                Toast.makeText(this@MainActivity, "Вы выбрали: $selectedItem", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
    }

    override fun showWeather(weatherResponse: WeatherResponse) = with(binding){
        temp.text = weatherResponse.current.tempC.toString()
        wind.text = weatherResponse.current.windKph.toString()
        humidity.text = weatherResponse.current.humidity.toString()
        rain.text = weatherResponse.current.precipMm.toInt().toString()
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }
}

