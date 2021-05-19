package com.myweather.mywhther.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {
    private const val BASE_URl = "https://api.caiyunapp.com/"
    private val  retrofit = Retrofit.Builder()
        .baseUrl(BASE_URl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    //参数是传递的 类的class 返回的是类
    fun<T> creat(serviceClass: Class<T>):T = retrofit.create(serviceClass)
    //使用 泛型的实化
    inline fun<reified T> creat():T = creat(T::class.java)
}