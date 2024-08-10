package org.lotka.xenonx.data.local.entity



import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import org.lotka.xenonx.domain.model.UnsplashImage
import org.lotka.xenonx.domain.util.Constants.UNSPLASH_IMAGE_TABLE

@Serializable
@Entity(tableName = UNSPLASH_IMAGE_TABLE)
data class UnsplashImageEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    @Embedded
    val urls: UrlsEntity,
    val likes: Int,
    @Embedded
    val user: UserEntity
)

fun UnsplashImage.toUnsplashImageEntity () : UnsplashImage{
    return UnsplashImage(
        id = id,
        urls = urls,
        likes = likes,
        user = user
    )
}