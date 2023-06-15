package com.example.snapzoo.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.snapzoo.data.AnimalRepository
import com.example.snapzoo.model.AnimalResponse

class SearchViewModel:ViewModel() {

    private val animalRepository = AnimalRepository()

    fun getAnimalList(): LiveData<List<AnimalResponse>?> {
        return animalRepository.getAnimalList()
    }


}


