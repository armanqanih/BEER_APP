package org.lotka.xenonx.presentation.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.lotka.xenonx.domain.model.UnsplashImage
import org.lotka.xenonx.domain.usecase.GetImagesUseCase
import org.lotka.xenonx.domain.util.Resource
import javax.inject.Inject

@HiltViewModel
class ImageViewModel @Inject constructor(
    private val getImagesUseCase: GetImagesUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()


    init {
        getImages( )
    }

    private fun getImages() {
        viewModelScope.launch {
            getImagesUseCase(state.value.page, state.value.perPage).collect { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.value = state.value.copy(
                            images = result.data ?: emptyList(),
                            page =  state.value.page + 1,
                            perPage = state.value.perPage,
                            isLoading = false
                        )
                    }
                    is Resource.Error -> {
                        _state.value = state.value.copy(
                            error = result.message,
                            isLoading = false
                        )
                    }
                    is Resource.Loading -> {
                        _state.value = state.value.copy(
                            isLoading = true
                        )
                    }
                }

            }
        }
    }
}
