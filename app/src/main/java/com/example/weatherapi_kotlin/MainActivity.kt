package com.example.weatherapi_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.loader.app.LoaderManager
import androidx.loader.content.Loader
import com.example.weatherapi_kotlin.data.CityData
import com.example.weatherapi_kotlin.data.WeatherForecast
import com.example.weatherapi_kotlin.db.DBHanlderAnko

class MainActivity : AppCompatActivity(), LoaderManager.LoaderCallbacks<ArrayList<WeatherForecast>> {

    val LOADER_ID = 101010
    var adapter: WeatherListViewAdapter? = null
    var mWeatherData: ArrayList<WeatherForecast>? = null
    val mCityArray = ArrayList<CityData>()
    val mDb = DBHanlderAnko(this)

    companion object{
        val SELECTED_CITY = 1100
        val REQUEST_CITY = 1101
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.add_city->{
                val intent = Intent(this, SelectCityActivity::class.java)
                startActivityForResult(intent, REQUEST_CITY)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onLoadFinished(loader: Loader<ArrayList<WeatherForecast>>, data: ArrayList<WeatherForecast>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            adapter.let {

            }

        }

}
