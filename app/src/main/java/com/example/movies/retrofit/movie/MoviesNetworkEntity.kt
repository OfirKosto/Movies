package com.example.movies.retrofit.movie

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MoviesNetworkEntity(
    @SerializedName("results")
    @Expose
    var movies: List<MovieNetworkEntity>

    ) {
}