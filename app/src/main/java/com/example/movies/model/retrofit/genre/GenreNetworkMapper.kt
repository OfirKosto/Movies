package com.example.movies.model.retrofit.genre

import com.example.movies.model.interfaces.IEntityMapper
import com.example.movies.model.dataclasses.Genre
import javax.inject.Inject

class GenreNetworkMapper
@Inject
constructor(): IEntityMapper<GenreNetworkEntity, Genre>{
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