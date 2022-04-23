package com.example.movies.room.genre

import com.example.movies.interfaces.IEntityMapper
import com.example.movies.model.Genre
import javax.inject.Inject

class GenreCacheMapper
@Inject
constructor(): IEntityMapper<GenreCacheEntity, Genre>{
    override fun mapFromEntity(entity: GenreCacheEntity): Genre {
        return Genre(
            id = entity.id,
            name = entity.name
        )
    }

    override fun mapToEntity(domainModel: Genre): GenreCacheEntity {
        return GenreCacheEntity(
            id = domainModel.id,
            name = domainModel.name
        )
    }

    fun mapFromEntityList(entities: List<GenreCacheEntity>): List<Genre>{
        return entities.map { mapFromEntity(it) }
    }
}