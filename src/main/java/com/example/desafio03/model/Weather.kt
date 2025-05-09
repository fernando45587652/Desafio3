package com.example.desafio03.model

data class Weather(
val location: Location,
val current: Current
)

data class Location(
    val name: String,
    val country:String
)

data class Current(
    val temp_c:Double,
    val temp_f:Double,
    val wind_mph:Double,
    val wind_kph:Double
)

