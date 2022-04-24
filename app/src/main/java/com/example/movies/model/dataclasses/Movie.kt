package com.example.movies.model.dataclasses

data class Movie(
    var id: Int,
    var title: String,
    var releaseDate: String,
    var genres: List<Int>
) {
}