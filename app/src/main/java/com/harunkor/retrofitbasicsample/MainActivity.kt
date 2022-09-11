package com.harunkor.retrofitbasicsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.harunkor.retrofitbasicsample.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

class MainActivity : AppCompatActivity() {

   private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        MarsApi.retrofitService.getProperties().enqueue(object : Callback<List<RealeStateModel>>{
            override fun onResponse(call: Call<List<RealeStateModel>>, response: Response<List<RealeStateModel>>) {
                response.body()?.let { responseList ->
                    binding.responseText.text = responseList.toString()
                    Log.v("PATIKA", responseList.toString())
                }
            }

            override fun onFailure(call: Call<List<RealeStateModel>>, t: Throwable) {
                Log.v("PATIKA",t.message.toString())
            }

        })


    }

}

