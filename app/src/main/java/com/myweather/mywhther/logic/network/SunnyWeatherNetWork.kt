package com.myweather.mywhther.logic.network

import com.myweather.mywhther.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

object SunnyWeatherNetWork {

    private val placeService = ServiceCreator.creat<PlaceService>()
    suspend fun searchPlaces(query: String):PlaceResponse{
       // val searchPlaces :Call<PlaceResponse> = placeService.searchPlaces(query)
       return placeService.searchPlaces(query).await()
    }
    //suspend fun searchPlaces(query: String) =placeService.searchPlaces(query).await()

        // val searchPlaces :Call<PlaceResponse> = placeService.searchPlaces(query)

    private suspend fun <T> Call<T>.await(): T {
        //协成  通过携程中转回调
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onFailure(call: Call<T>, t: Throwable) {
                    TODO("Not yet implemented")
                   continuation.resumeWithException(t)
                }

                override fun onResponse(call: Call<T>, response: Response<T>) {
                    TODO("Not yet implemented")
                    val body = response.body()
                    if (body != null) continuation.resume(body)
                    else continuation.resumeWithException(RuntimeException("response body is null"))
                }
            })
        }
    }
}