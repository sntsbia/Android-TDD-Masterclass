package com.sntsb.groovy.data.services

import com.sntsb.groovy.domain.model.PlaylistRaw
import kotlinx.coroutines.flow.Flow

interface PlaylistService {

    suspend fun fetchPlaylists(): Flow<Result<List<PlaylistRaw>>>

}