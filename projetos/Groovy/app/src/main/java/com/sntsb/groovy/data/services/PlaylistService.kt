package com.sntsb.groovy.data.services

import com.sntsb.groovy.data.model.Playlist
import kotlinx.coroutines.flow.Flow

interface PlaylistService {

    suspend fun fetchPlaylists(): Flow<Result<List<Playlist>>>

}