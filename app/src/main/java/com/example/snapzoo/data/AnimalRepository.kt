package com.example.snapzoo.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.snapzoo.model.AnimalResponse
import com.example.snapzoo.model.PredictResponse
import com.example.snapzoo.network.ApiConfig
import com.example.snapzoo.network.ApiService
import com.google.android.gms.common.api.Api
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class AnimalRepository {
    private val apiService = ApiService.create()

    fun sendImageToApi(file: File): Call<PredictResponse> {
        val requestImageFile = file.asRequestBody("image/jpeg".toMediaTypeOrNull())
        val imageMultipart: MultipartBody.Part = MultipartBody.Part.createFormData("file", file.name, requestImageFile)
        return apiService.predictAnimal(imageMultipart)
    }

    fun getAnimalList(): LiveData<List<AnimalResponse>?> {
        val liveDataList: MutableLiveData<List<AnimalResponse>?> = MutableLiveData()
        val call = apiService.getSearchAnimal()

        call.enqueue(object : Callback<List<AnimalResponse>> {
            override fun onResponse(call: Call<List<AnimalResponse>>, response: Response<List<AnimalResponse>>) {
                liveDataList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<AnimalResponse>>, t: Throwable) {
                liveDataList.postValue(null)
                Log.d("Failure", t.message ?: "")
            }
        })

        return liveDataList
    }
}