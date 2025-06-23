package com.sntsb.groovy.data.api

import com.sntsb.groovy.data.model.Playlist
import retrofit2.http.GET

interface PlaylistAPI {

    @GET("playlists")
    suspend fun fetchAllPlaylists(): List<Playlist>
}