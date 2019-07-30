package com.example.weatherapi_kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.weatherapi_kotlin.data.CityData

class CityListAdapter(context: Context, cityData: ArrayList<CityData>)  //override도 : 으로 표시
    : ArrayAdapter<CityData>(context, R.layout.layout_city_list, cityData){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater : LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var mainView = convertView
        mainView = mainView?:inflater.inflate(R.layout.layout_city_list, parent, false)
        val name : TextView = mainView!!.findViewById(R.id.city_name) as TextView
//        val data:CityData = getItem(position)
//        name.text = data.name
//        mainView.tag = data._id

        return mainView!!
    }
}