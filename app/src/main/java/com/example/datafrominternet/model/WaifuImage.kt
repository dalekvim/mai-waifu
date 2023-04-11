package com.example.datafrominternet.model

data class Images(
    val images: List<Waifu>
)

data class Waifu(
    val source: String,
    val url: String
)