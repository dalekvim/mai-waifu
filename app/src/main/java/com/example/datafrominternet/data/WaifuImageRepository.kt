package com.example.datafrominternet.data

import androidx.annotation.Keep
import com.example.datafrominternet.model.Images
import com.example.datafrominternet.network.WaifuApiService

interface WaifuImageRepository {
    suspend fun getWaifuImages(): Images
}

@Keep
class NetworkWaifuImagesRepository(
    private val waifuApiService: WaifuApiService
) : WaifuImageRepository {
    override suspend fun getWaifuImages(): Images = waifuApiService.getWaifu()
}