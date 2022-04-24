package com.example.movies.model.room.movie

import com.example.movies.model.interfaces.IEntityMapper
import com.example.movies.model.dataclasses.Movie
import javax.inject.Inject

class MovieCacheMapper
@Inject
constructor(): IEntityMapper<MovieCacheEntity, Movie>{
    override fun mapFromEntity(entity: MovieCacheEntity): Movie {
        return Movie(
            id = entity.id,
            title =  entity.title,
            releaseDate = entity.releaseDate,
            genres = entity.genres!!.toList()
        )
    }

    override fun mapToEntity(domainModel: Movie): MovieCacheEntity {
        return MovieCacheEntity(
            id = domainModel.id,
            title =  domainModel.title,
            releaseDate = domainModel.releaseDate,
            genres = domainModel.genres.toMutableList()
        )
    }

    fun mapFromEntityList(entities: List<MovieCacheEntity>): List<Movie>{
        return entities.map { mapFromEntity(it) }
    }


}