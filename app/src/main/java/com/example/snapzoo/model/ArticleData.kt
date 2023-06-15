package com.example.snapzoo.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArticleData(var title : String, var Image : String, var desc : String):Parcelable
