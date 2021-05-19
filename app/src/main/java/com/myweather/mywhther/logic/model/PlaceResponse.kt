package com.myweather.mywhther.logic.model

import android.location.Address
import com.google.gson.annotations.SerializedName

data class PlaceResponse(val status:String,val places:List<Place>)
//@SerializedName json 与实体类建立映射关系
data class Place(val name:String,val location:Location,@SerializedName("formatted_address") val address: String)
data class Location(val lng:String,val lat:String)

data class User(var fristName:String,val lastName:String,var age:Int)