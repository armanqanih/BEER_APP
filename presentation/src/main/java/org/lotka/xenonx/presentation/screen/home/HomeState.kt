package org.lotka.xenonx.presentation.screen.home

import org.lotka.xenonx.domain.model.UnsplashImage

data class HomeState (
    val images: List<UnsplashImage> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val page: Int = 1,
    val perPage: Int = 10,
    val navigateToSearchBar: Boolean = false

)