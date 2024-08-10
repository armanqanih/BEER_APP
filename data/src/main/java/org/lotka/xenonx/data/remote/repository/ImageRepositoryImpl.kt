package org.lotka.xenonx.data.remote.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.lotka.xenonx.data.api.UnsplashApi
import org.lotka.xenonx.data.local.UnsplashDatabase
import org.lotka.xenonx.data.local.entity.toUnsplashImageEntity
import org.lotka.xenonx.domain.model.UnsplashImage
import org.lotka.xenonx.domain.repository.ImagesRepository
import org.lotka.xenonx.domain.util.Resource
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val api: UnsplashApi,
    private val database: UnsplashDatabase

): ImagesRepository {
    override suspend fun getAllImages(
        page: Int,
        perPage: Int,
    ): Flow<Resource<List<UnsplashImage>>> {
        return flow {
            emit(Resource.Loading())

            try {
                val imageDtos = api.getAllImages(page, perPage)
                val images = imageDtos.map { it.toUnsplashImageEntity() }

                // Optional: Save to local database
//                database.unsplashImageDao().insertAll(images)

                emit(Resource.Success(images))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
            }
        }

    }


}