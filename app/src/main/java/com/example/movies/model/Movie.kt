package com.example.movies.model

data class Movie(
    var id: Int,
    var title: String,
    var releaseDate: String,
    var genres: List<Int>
) {
}