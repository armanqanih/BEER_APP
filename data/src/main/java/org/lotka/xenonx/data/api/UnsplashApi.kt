package org.lotka.xenonx.data.api

import org.lotka.xenonx.domain.model.SearchResult
import org.lotka.xenonx.domain.model.UnsplashImage
import retrofit2.http.GET
import retrofit2.http.Query


import retrofit2.http.Headers


interface UnsplashApi {

    @Headers("Authorization: Client-ID ${ApiKey}")
    @GET("/photos")
    suspend fun getAllImages(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): List<UnsplashImage>

    @Headers("Authorization: Client-ID ${ApiKey}")
    @GET("/search/photos")
    suspend fun searchImages(
        @Query("query") query: String,
        @Query("per_page") perPage: Int
    ): SearchResult


    companion object {
        const val ApiKey = "Plkp1Yw1X3GnvJhINfFjTG8pMJ8HRPOhonfP95ZXaCg"
    }
}