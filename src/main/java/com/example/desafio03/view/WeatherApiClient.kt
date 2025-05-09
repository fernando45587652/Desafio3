package com.example.desafio03.view

import com.example.desafio03.model.WeatherApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WeatherApiClient {

        private const val BASE_URL = "https://api.weatherapi.com/v1/"

        val api: WeatherApiService by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeatherApiService::class.java)}
    }
