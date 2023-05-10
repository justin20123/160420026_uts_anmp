package com.example.a160420026_uts_anmp.model

import com.google.gson.annotations.SerializedName

//data class Student(
//    val id:String?,
//    val name:String?,
//    val dob:String?,
//    val phone:String?,
//    val photoUrl:String?
//)

data class Book(
    val id:String?,
    val title:String?,
    val subtitle:String?,
    val author:String?,
    @SerializedName("published")
    val publishedOn:String?,
    val description:String?
)
