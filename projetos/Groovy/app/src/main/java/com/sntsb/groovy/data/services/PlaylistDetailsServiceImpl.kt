package com.sntsb.groovy.data.services

import com.sntsb.groovy.data.api.PlaylistAPI
import com.sntsb.groovy.domain.model.PlaylistDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PlaylistDetailsServiceImpl @Inject constructor(
    private val api: PlaylistAPI
) {
    suspend fun fetchPlaylistDetails(id: String): Flow<Result<PlaylistDetail>> {
        return flow {
            emit(Result.success(api.fetchPlaylistDetails(id)))
        }.catch {
            emit(Result.failure(RuntimeException("Something went wrong")))
        }
    }
}