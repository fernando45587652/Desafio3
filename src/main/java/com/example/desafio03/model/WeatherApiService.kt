package com.example.desafio03.model

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
        @GET("current.json")

        suspend fun getCurrentWeather(
            @Query("key") apiKey: String,
            @Query("q") city: String
        ): Weather
    }
