package org.lotka.xenonx.domain.usecase
import kotlinx.coroutines.flow.Flow
import org.lotka.xenonx.domain.model.UnsplashImage
import org.lotka.xenonx.domain.repository.ImagesRepository
import org.lotka.xenonx.domain.util.Resource
import javax.inject.Inject

class GetImagesUseCase @Inject constructor(
    private val repository: ImagesRepository
) {
    suspend operator fun invoke(page: Int, perPage: Int): Flow<Resource<List<UnsplashImage>>> {
        return repository.getAllImages(page, perPage)
    }
}
