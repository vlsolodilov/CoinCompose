package com.solodilov.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinDetailDto(
    @SerialName("name")
    val name: String,
    @SerialName("categories")
    val categories: List<String>,
    @SerialName("description")
    val descriptionDto: DescriptionDto,
    @SerialName("image")
    val imageDto: ImageDto,
)