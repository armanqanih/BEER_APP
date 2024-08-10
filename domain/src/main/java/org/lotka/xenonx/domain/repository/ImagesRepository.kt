package org.lotka.xenonx.domain.repository

import kotlinx.coroutines.flow.Flow
import org.lotka.xenonx.domain.model.UnsplashImage
import org.lotka.xenonx.domain.util.Resource

interface ImagesRepository {

 suspend fun getAllImages(page: Int,perPage: Int):Flow<Resource<List<UnsplashImage>>>

}