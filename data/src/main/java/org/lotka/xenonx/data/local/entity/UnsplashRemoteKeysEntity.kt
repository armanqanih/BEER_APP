package org.lotka.xenonx.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.lotka.xenonx.domain.util.Constants.UNSPLASH_REMOTE_KEYS_TABLE


@Entity(tableName = UNSPLASH_REMOTE_KEYS_TABLE)
data class UnsplashRemoteKeysEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val prevPage: Int?,
    val nextPage: Int?
)