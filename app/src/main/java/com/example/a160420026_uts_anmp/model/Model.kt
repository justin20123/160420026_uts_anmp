package com.example.a160420026_uts_anmp.model

import com.google.gson.annotations.SerializedName


data class Book(
    val id:String?,
    val title:String?,
    val subtitle:String?,
    val author:String?,
    @SerializedName("published")
    val publishedOn:String?,
    val description:String?
)

data class Profile(
    var name:String?,
    var phoneNumber:String?,
    var favoriteBook:String?
    )
