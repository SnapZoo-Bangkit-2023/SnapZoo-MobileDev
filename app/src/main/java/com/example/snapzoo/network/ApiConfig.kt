package com.example.snapzoo.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiConfig {
    companion object{
        val BASE_URL = "https://snapzoo-capstone.et.r.appspot.com/"

        fun getApiService() : Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
    }

}