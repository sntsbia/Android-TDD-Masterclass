package com.sntsb.groovy.data.services

import com.sntsb.groovy.data.model.Playlist
import kotlinx.coroutines.flow.Flow

class PlaylistServiceImpl : PlaylistService {

    override suspend fun fetchPlaylists(): Flow<Result<List<Playlist>>> {
        TODO("Not yet implemented")
    }

}