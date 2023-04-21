package com.example.datafrominternet.data

import androidx.annotation.Keep
import com.example.datafrominternet.model.Images
import com.example.datafrominternet.network.WaifuApiService

interface WaifuImageRepository {
    suspend fun getWaifuImages(): Images
    suspend fun getWaifuImagesByTag(included_tags: List<String>): Images
}

@Keep
class NetworkWaifuImagesRepository(
    private val waifuApiService: WaifuApiService
) : WaifuImageRepository {
    override suspend fun getWaifuImages(): Images = waifuApiService.getWaifu()
    override suspend fun getWaifuImagesByTag(included_tags: List<String>): Images =
        waifuApiService.getWaifuByTag(included_tags = included_tags)
}