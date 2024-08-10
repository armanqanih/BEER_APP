package org.lotka.xenonx.data.local.entity

import androidx.room.Embedded
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserEntity(
    @SerialName("links")
    @Embedded
    val userLinks: UserLinksEntity,
    val username: String
)