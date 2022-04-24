package com.example.movies.model.retrofit.movie

import com.example.movies.model.interfaces.IEntityMapper
import com.example.movies.model.dataclasses.Movie
import javax.inject.Inject

class MovieNetworkMapper
@Inject
constructor(): IEntityMapper<MovieNetworkEntity, Movie>{
    override fun mapFromEntity(entity: MovieNetworkEntity): Movie {
        return Movie(
            id = entity.id,
            title = entity.title,
            releaseDate = entity.releaseDate,
            genres = entity.genres
        )
    }

    override fun mapToEntity(domainModel: Movie): MovieNetworkEntity {
        return MovieNetworkEntity(
            id = domainModel.id,
            title = domainModel.title,
            releaseDate = domainModel.releaseDate,
            genres = domainModel.genres
        )
    }

    fun mapFromEntityList(entities: List<MovieNetworkEntity>): List<Movie>{
        return entities.map { mapFromEntity(it) }
    }

}