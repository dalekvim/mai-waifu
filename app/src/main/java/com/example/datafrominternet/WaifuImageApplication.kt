package com.example.datafrominternet

import android.app.Application
import com.example.datafrominternet.data.AppContainer
import com.example.datafrominternet.data.DefaultAppContainer

class WaifuImageApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}