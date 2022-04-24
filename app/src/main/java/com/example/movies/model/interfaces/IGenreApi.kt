package com.example.movies.model.interfaces

import com.example.movies.model.retrofit.genre.GenresNetworkEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface IGenreApi {

    @GET("genre/movie/list")
    suspend fun getGenres(
        @Query("api_key") apiKey: String
    ): GenresNetworkEntity

}