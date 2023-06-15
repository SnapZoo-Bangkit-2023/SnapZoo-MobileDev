package com.example.snapzoo.model

import com.google.gson.annotations.SerializedName

data class PredictResponse(

	@field:SerializedName("label")
	val label: String? = null,

	@field:SerializedName("hewan")
	val hewan: AnimalResponse? = null
)


