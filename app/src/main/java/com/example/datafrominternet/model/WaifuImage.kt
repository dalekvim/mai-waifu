package com.example.datafrominternet.model

import androidx.annotation.Keep

@Keep
data class Images(
    val images: List<Waifu>
)

@Keep
data class Waifu(
    val source: String?,
    val url: String,
    val tags: List<Tag>?
)

@Keep
data class Tag(
    val name: String
)