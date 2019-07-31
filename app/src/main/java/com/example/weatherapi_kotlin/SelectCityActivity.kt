package com.example.weatherapi_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.weatherapi_kotlin.data.CityArray
import com.example.weatherapi_kotlin.data.CityData
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_select_city.*
import java.io.InputStreamReader

class SelectCityActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_city)

        //assests 에서 데이터 불러옴
        val inputStream = InputStreamReader(assets.open("areaCorde"))
        val cityData: CityArray = Gson().fromJson(inputStream, CityArray::class.java)

        val adapter = CityListAdapter(this, cityData.city)
        city_list.adapter = adapter //kotlin extension library로 레이아웃의 뷰를 findbyviewid 없이 id로 접근 가능
        city_list.setOnItemClickListener { adapterView, view, i, l ->
            val text: TextView = view.findViewById(R.id.city_name) as TextView
            saveData(view.tag as String, text.text as String)
            setResult(MainActivity.SELECTED_CITY)
            finish()
        }
    }

    fun saveData(api_id:String, name:String){
        val db = DBHandlerAnko(this)
        db.saveCity(CityData(api_id, name))
    }
}
