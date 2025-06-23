package com.sntsb.groovy.data.repository

import com.sntsb.groovy.data.model.Playlist

interface PlaylistRepository {

    fun getPlaylists(): Result<List<Playlist>>

}
