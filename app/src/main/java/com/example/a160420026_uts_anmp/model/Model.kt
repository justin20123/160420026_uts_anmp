package com.example.advweek4.model

import com.google.gson.annotations.SerializedName

//data class Student(
//    val id:String?,
//    val name:String?,
//    val dob:String?,
//    val phone:String?,
//    val photoUrl:String?
//)

data class Book(
    @SerializedName("isbn")
    val id:String?,
    val title:String?,
    val subtitle:String?,
    val author:String?,
    @SerializedName("published")
    val publishedOn:String?,
    val publisher:String?
)
