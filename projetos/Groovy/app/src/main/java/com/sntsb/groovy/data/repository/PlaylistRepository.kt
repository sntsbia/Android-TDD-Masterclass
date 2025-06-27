package com.sntsb.groovy.data.repository

import com.sntsb.groovy.domain.model.Playlist
import kotlinx.coroutines.flow.Flow

interface PlaylistRepository {

    suspend fun getPlaylists(): Flow<Result<List<Playlist>>>

}
