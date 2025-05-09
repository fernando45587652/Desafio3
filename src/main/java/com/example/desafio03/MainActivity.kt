package com.example.desafio03

import android.os.Bundle
import android.widget.Button
import com.example.desafio03.controller.WeatherView
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.desafio03.controller.WeatherController
import com.example.desafio03.R

class MainActivity : AppCompatActivity(), WeatherView {

    private lateinit var controller: WeatherController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        controller = WeatherController(this)

        val etCity = findViewById<EditText>(R.id.etCity)
        val btnFetch = findViewById<Button>(R.id.btnFetch)

        btnFetch.setOnClickListener {
            val city = etCity.text.toString()
            if (city.isNotEmpty()) {
                controller.fetchWeather(city)
            }
        }
    }

    override fun showWeather(result: String) {
        findViewById<TextView>(R.id.tvResult).text = result
    }

    override fun showError(error: String) {
        findViewById<TextView>(R.id.tvResult).text = "Error: $error"
    }
}
