package com.example.snapzoo.network


import com.example.snapzoo.model.AnimalResponse
import com.example.snapzoo.model.PredictResponse

import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ApiService {

    @Multipart
    @POST("predict")
    fun predictAnimal(@Part image : MultipartBody.Part) : Call<PredictResponse>

    @GET("deskripsi")
    fun getSearchAnimal(
    ): Call<List<AnimalResponse>>


    companion object {
        private const val BASE_URL = "https://snapzoo-capstone.et.r.appspot.com/"

        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}