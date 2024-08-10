package org.lotka.xenonx.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.lotka.xenonx.domain.model.UnsplashImage


@Dao
interface UnsplashImageDao {

    @Query("SELECT * FROM UNSPLASH_IMAGE_TABLE")
    fun getAllImages(): PagingSource<Int, UnsplashImage>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addImages(images: List<UnsplashImage>)

    @Query("DELETE FROM UNSPLASH_IMAGE_TABLE")
    suspend fun deleteAllImages()

}