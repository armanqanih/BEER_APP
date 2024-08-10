
package org.lotka.xenonx.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import org.lotka.xenonx.data.local.dao.UnsplashImageDao
import org.lotka.xenonx.data.local.dao.UnsplashRemoteKeysDao
import org.lotka.xenonx.data.local.entity.UnsplashRemoteKeysEntity
import org.lotka.xenonx.domain.model.UnsplashImage


@Database(entities = [UnsplashImage::class, UnsplashRemoteKeysEntity::class], version = 1)
abstract class UnsplashDatabase : RoomDatabase() {

    abstract fun unsplashImageDao(): UnsplashImageDao
    abstract fun unsplashRemoteKeysDao(): UnsplashRemoteKeysDao

}
