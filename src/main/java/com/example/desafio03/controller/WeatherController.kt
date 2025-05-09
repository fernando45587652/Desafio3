package com.example.desafio03.controller

import com.example.desafio03.view.WeatherApiClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private const val API_KEY = "eee2ccb1e72e436d9db53239250905"

class WeatherController(private val view: WeatherView) {

    private val apiService = WeatherApiClient.api

    fun fetchWeather(city: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiService.getCurrentWeather(API_KEY, city)
                val info = """
                    City: ${response.location.name}
                    Country: ${response.location.country}
                    Temp: ${response.current.temp_c}°C / ${response.current.temp_f}°F
                    Wind: ${response.current.wind_kph} kph / ${response.current.wind_mph} mph
                """.trimIndent()
                withContext(Dispatchers.Main) {
                    view.showWeather(info)
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    view.showError(e.message ?: "Error al obtener tiempo")
                }
            }
        }
    }
}