package com.example.weatherapi_kotlin.data

data class CityArray(val city: ArrayList<CityData>)
data class CityData(val _id:String, val name:String)