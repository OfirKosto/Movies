package com.example.movies.retrofit

import com.example.movies.interfaces.EntityMapper
import com.example.movies.model.Genre
import javax.inject.Inject

class GenreNetworkMapper
@Inject
constructor(): EntityMapper<GenreNetworkEntity, Genre>{
    override fun mapFromEntity(entity: GenreNetworkEntity): Genre {
        return Genre(
            id = entity.id,
            name = entity.name
        )
    }

    override fun mapToEntity(domainModel: Genre): GenreNetworkEntity {
        return GenreNetworkEntity(
            id = domainModel.id,
            name = domainModel.name
        )
    }


    fun mapFromEntityList(entities: List<GenreNetworkEntity>): List<Genre>{
        return entities.map { mapFromEntity(it) }
    }
}