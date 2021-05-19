package com.myweather.mywhther.logic

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.myweather.mywhther.logic.model.Place
import com.myweather.mywhther.logic.network.PlaceService
import com.myweather.mywhther.logic.network.SunnyWeatherNetWork
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import java.lang.RuntimeException

object Repository {

    fun searchPlaces(query:String) : LiveData<Result<List<Place>>>{
        val liveData = liveData(Dispatchers.IO) {
            val result = try {

                val placeResponse = SunnyWeatherNetWork.searchPlaces(query)

                if (placeResponse.status == "ok") {
                    val places = placeResponse.places
                    Result.success(places)
                } else {
                    Result.failure(RuntimeException("${placeResponse.status}"))
                }
            } catch (e: Exception) {
                Result.failure<List<Place>>(e)
            }
            emit(result)
        }
        return liveData
    }
}