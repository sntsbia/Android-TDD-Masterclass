package com.sntsb.groovy.data.api

import com.sntsb.groovy.domain.model.PlaylistDetail
import com.sntsb.groovy.domain.model.PlaylistRaw
import retrofit2.http.GET
import retrofit2.http.Path

interface PlaylistAPI {

    @GET("playlists")
    suspend fun fetchAllPlaylists(): List<PlaylistRaw>

    @GET("playlists/{id}")
    suspend fun fetchPlaylistDetails(@Path("id") id: String): PlaylistDetail
}