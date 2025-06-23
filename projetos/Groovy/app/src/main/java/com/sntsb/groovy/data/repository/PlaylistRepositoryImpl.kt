package com.sntsb.groovy.data.repository

import com.sntsb.groovy.data.model.Playlist
import com.sntsb.groovy.data.services.PlaylistService
import kotlinx.coroutines.flow.Flow

class PlaylistRepositoryImpl(
    private val service: PlaylistService
) : PlaylistRepository {

    override suspend fun getPlaylists(): Flow<Result<List<Playlist>>> = service.fetchPlaylists()

}