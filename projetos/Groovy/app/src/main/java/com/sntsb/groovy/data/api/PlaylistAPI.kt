package com.sntsb.groovy.data.api

import com.sntsb.groovy.data.model.Playlist

interface PlaylistAPI {

    suspend fun fetchAllPlaylists(): List<Playlist>
}