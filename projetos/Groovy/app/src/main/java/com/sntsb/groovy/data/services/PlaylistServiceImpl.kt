package com.sntsb.groovy.data.services

import com.sntsb.groovy.data.api.PlaylistAPI
import com.sntsb.groovy.data.model.Playlist
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PlaylistServiceImpl @Inject constructor(
    private val api: PlaylistAPI
) : PlaylistService {

    override suspend fun fetchPlaylists(): Flow<Result<List<Playlist>>> {

        return flow {
            emit(Result.success(api.fetchAllPlaylists()))
        }.catch {
            emit(Result.failure(RuntimeException("Something went wrong")))
        }
    }

}