package com.example.weatherapi_kotlin

import android.content.Context
import androidx.loader.content.AsyncTaskLoader
import com.example.weatherapi_kotlin.data.CityData
import com.example.weatherapi_kotlin.data.DayData
import com.example.weatherapi_kotlin.data.WeatherForecast
import com.example.weatherapi_kotlin.data.WeekData
import com.google.gson.Gson
import java.io.InputStreamReader
import java.net.URL

class ForecastDtaLoader(context: Context, val cities:ArrayList<CityData>)
    :AsyncTaskLoader<ArrayList<WeatherForecast>>(context){
    val API_KEY:String = ""
    val Current_URL:String = ""
    val Forcast_URL = ""
    val ICON_URL = ""

    override fun loadInBackground(): ArrayList<WeatherForecast>? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val city_weather = ArrayList<WeatherForecast>()
        cities.forEach {
            val cur_url = Current_URL+it._id+"&units=metric&APPID=$API_KEY"
            val readData = URL(cur_url).readText()
            val current:DayData = Gson().fromJson(readData, DayData::class.java)
            current.api_id = it._id

            val fore_url = Forcast_URL+it._id+"&units=metric&APPID=$API_KEY"
            val url = URL(fore_url)
            val inputstream = InputStreamReader(url.openStream())

            val week:WeekData = Gson().fromJson(inputstream, WeekData::class.java)
            val forecast:WeatherForecast = WeatherForecast(current, week, ICON_URL)
            city_weather.add(forecast)
        }
        return city_weather
    }
}