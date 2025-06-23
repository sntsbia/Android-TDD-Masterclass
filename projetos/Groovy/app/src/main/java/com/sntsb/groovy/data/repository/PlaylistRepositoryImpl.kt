package com.sntsb.groovy.data.repository

import com.sntsb.groovy.data.model.Playlist
import kotlinx.coroutines.flow.Flow

class PlaylistRepositoryImpl : PlaylistRepository {
    override suspend fun getPlaylists(): Flow<Result<List<Playlist>>> {
        TODO("Not yet implemented")
    }
}