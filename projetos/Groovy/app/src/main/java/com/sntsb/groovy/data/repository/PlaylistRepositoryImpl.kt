package com.sntsb.groovy.data.repository

import com.sntsb.groovy.data.mapper.PlayListMapper
import com.sntsb.groovy.data.services.PlaylistService
import com.sntsb.groovy.domain.model.Playlist
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PlaylistRepositoryImpl @Inject constructor(
    private val service: PlaylistService, private val mapper: PlayListMapper
) : PlaylistRepository {

    override suspend fun getPlaylists(): Flow<Result<List<Playlist>>> =
        service.fetchPlaylists().map {
            if (it.isFailure) {
                return@map Result.failure(it.exceptionOrNull() ?: RuntimeException("Unknown error"))
            }
            Result.success(mapper.invoke(it.getOrNull().orEmpty()))
        }

}