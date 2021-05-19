package com.myweather.mywhther.logic.network



import com.myweather.mywhther.logic.model.PlaceResponse
import com.myweather.mywhther.myWeatherApplication
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceService {
    @GET("v2/place?token=${myWeatherApplication.TOKEN}&&lang=zh_CN")
    fun searchPlaces(@Query("query") query:String): Call<PlaceResponse>
}