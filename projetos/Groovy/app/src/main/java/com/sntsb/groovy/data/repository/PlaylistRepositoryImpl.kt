package com.sntsb.groovy.data.repository

import com.sntsb.groovy.data.model.Playlist
import com.sntsb.groovy.data.services.PlaylistService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PlaylistRepositoryImpl @Inject constructor(
    private val service: PlaylistService
) : PlaylistRepository {

    override suspend fun getPlaylists(): Flow<Result<List<Playlist>>> = service.fetchPlaylists()

}