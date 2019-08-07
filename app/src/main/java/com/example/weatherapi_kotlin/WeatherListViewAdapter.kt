package com.example.weatherapi_kotlin

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapi_kotlin.data.WeatherForecast

class WeatherListViewAdapter(val context: Context, val data:ArrayList<WeatherForecast>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    var mWeatherData = ArrayList<WeatherForecast>(data)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("not implemented") //To change body of created f var mWeatherData = ArrayList<WeatherForecast>(data)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

    override fun getItemCount(): Int = mWeatherData.size
}