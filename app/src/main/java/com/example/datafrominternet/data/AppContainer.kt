package com.example.datafrominternet.data

import androidx.annotation.Keep
import com.example.datafrominternet.network.WaifuApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val waifuImageRepository: WaifuImageRepository
}

@Keep
class DefaultAppContainer : AppContainer {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.waifu.im/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    private val retrofitService: WaifuApiService by lazy {
        retrofit.create(WaifuApiService::class.java)
    }

    override val waifuImageRepository: WaifuImageRepository by lazy {
        NetworkWaifuImagesRepository(retrofitService)
    }
}