package org.lotka.xenonx.data.local.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class SearchResultEntity(
    @SerialName("results")
    val images: List<UnsplashImageEntity>,
)