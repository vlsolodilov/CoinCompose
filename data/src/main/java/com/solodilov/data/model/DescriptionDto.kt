package com.solodilov.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DescriptionDto(
    @SerialName("en")
    val en: String
)