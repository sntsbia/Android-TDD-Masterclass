package com.sntsb.groovy.data.api

import com.sntsb.groovy.domain.model.PlaylistRaw
import retrofit2.http.GET

interface PlaylistAPI {

    @GET("playlists")
    suspend fun fetchAllPlaylists(): List<PlaylistRaw>
}