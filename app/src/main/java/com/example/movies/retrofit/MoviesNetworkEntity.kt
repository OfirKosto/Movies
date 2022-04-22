package com.example.movies.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MoviesNetworkEntity(
    @SerializedName("results")
    @Expose
    var movies: List<MoviesNetworkEntity>

    ) {
}