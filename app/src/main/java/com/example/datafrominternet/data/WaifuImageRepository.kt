package com.example.datafrominternet.data

import com.example.datafrominternet.model.Images
import com.example.datafrominternet.network.WaifuApiService

interface WaifuImageRepository {
    suspend fun getWaifuImages(): Images
}

class NetworkWaifuImagesRepository(
    private val waifuApiService: WaifuApiService
) : WaifuImageRepository {
    override suspend fun getWaifuImages(): Images = waifuApiService.getWaifu()
}