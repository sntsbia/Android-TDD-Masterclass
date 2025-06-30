package com.sntsb.groovy.data.services

import com.sntsb.groovy.domain.model.PlaylistDetail
import kotlinx.coroutines.flow.Flow

interface PlaylistDetailsService {
    suspend fun fetchPlaylistDetails(id: String): Flow<Result<PlaylistDetail>>
}