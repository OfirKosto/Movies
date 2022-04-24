package com.example.movies.model.interfaces

import com.example.movies.model.retrofit.movie.MoviesNetworkEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface IMovieApi {

    @GET("discover/movie")
    suspend fun getMovies(
        @Query("api_key") apiKey: String,
        @Query("primary_release_year") year: String,
        @Query("page") page: String
    ): MoviesNetworkEntity

}