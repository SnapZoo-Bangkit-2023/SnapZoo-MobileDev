package com.example.snapzoo.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class AnimalResponse(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("habitat")
	val habitat: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("kingdom")
	val kingdom: String? = null,

	@field:SerializedName("phylum")
	val phylum: String? = null,

	@field:SerializedName("genus")
	val genus: String? = null,

	@field:SerializedName("species")
	val species: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("diet")
	val diet: String? = null,

	@field:SerializedName("family")
	val family: String? = null,

	@field:SerializedName("class")
	val jsonMemberClass: String? = null,

	@field:SerializedName("order")
	val order: String? = null,

	@field:SerializedName("reproduction")
	val reproduction: String? = null
) : Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString()
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(image)
		parcel.writeString(habitat)
		parcel.writeString(description)
		parcel.writeString(kingdom)
		parcel.writeString(phylum)
		parcel.writeString(genus)
		parcel.writeString(species)
		parcel.writeString(name)
		parcel.writeString(diet)
		parcel.writeString(family)
		parcel.writeString(jsonMemberClass)
		parcel.writeString(order)
		parcel.writeString(reproduction)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<AnimalResponse> {
		override fun createFromParcel(parcel: Parcel): AnimalResponse {
			return AnimalResponse(parcel)
		}

		override fun newArray(size: Int): Array<AnimalResponse?> {
			return arrayOfNulls(size)
		}
	}
}
