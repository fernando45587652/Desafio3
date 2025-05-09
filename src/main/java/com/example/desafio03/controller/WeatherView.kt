package com.example.desafio03.controller

interface WeatherView {
        fun showWeather(result: String)
        fun showError(error: String)
}