package com.myweather.mywhther

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class myWeatherApplication: Application() {
    //定义静态变量
    companion object{
        @SuppressLint("StaticFieldLeak")
        //告诉变量一会赋值
        lateinit var context: Context;

        const val TOKEN = ""
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext;
    }
}