package com.example.snapzoo.ui.scan

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.snapzoo.data.AnimalRepository
import com.example.snapzoo.model.AnimalResponse
import com.example.snapzoo.model.PredictResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class ScanViewModel: ViewModel() {

    private val animalRepository = AnimalRepository()

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _animalResponse = MutableLiveData<AnimalResponse>()
    val animalResponse: LiveData<AnimalResponse> get() = _animalResponse

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    fun sendImage(file: File) {
        _isLoading.value = true

        val call = animalRepository.sendImageToApi(file)
        call.enqueue(object : Callback<PredictResponse> {
            override fun onResponse(call: Call<PredictResponse>, response: Response<PredictResponse>) {
                if (response.isSuccessful) {
                    val predictResponse = response.body()
                    _isLoading.value = false

                    if (predictResponse != null) {
                        if (predictResponse.hewan != null) {
                            _animalResponse.value = predictResponse.hewan!!
                        } else {
                            _isLoading.value = false
                        _errorMessage.value = "Animal Data Null"
                        }
                    } else {
                        _isLoading.value = false
                        _errorMessage.value = "Respon Body Null"
                    }
                } else {
                    _isLoading.value = false
                    _errorMessage.value = "Predict Failed, Try Again!"
                }
            }

            override fun onFailure(call: Call<PredictResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e("animalResponse", "onFailure: ", t)
            }
        })
    }
}