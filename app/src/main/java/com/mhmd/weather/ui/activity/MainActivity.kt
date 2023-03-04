package com.mhmd.weather.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.google.gson.Gson
import com.mhmd.weather.databinding.ActivityMainBinding
import com.mhmd.weather.domain.models.model.WeResponse
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val mainMvvm : MainViewModel by viewModels()

    private var edtSearch : String ? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClick.setOnClickListener {
            val edtWeather = binding.edtWeather.text.toString()
            edtSearch = edtWeather
            if (edtWeather.isNotEmpty())
            {
                mainMvvm.getWeatherResponse(edtWeather , "dd7e806d64e0f84f608f1d650c7fd074")
                setDataInView()
            }
        }
    }


    private fun setDataInView() {
        lifecycleScope.launch {
            for (i in mainMvvm.getDataFromLocal()) {
                if (i.json.toString().isNotEmpty() && i.json != null) {
                    val response = Gson().fromJson(i.json, WeResponse::class.java)
                   if (response.city?.name == edtSearch)
                   {
                       binding.cityName.text = response.city?.name
                       val weather = response.list?.get(0)?.weather?.get(0)?.description
                       binding.weather.text = weather
                       Log.d("testApppp", "up+" + response.city?.name.toString())
                   }
                   }
                }
            }
        }
}




