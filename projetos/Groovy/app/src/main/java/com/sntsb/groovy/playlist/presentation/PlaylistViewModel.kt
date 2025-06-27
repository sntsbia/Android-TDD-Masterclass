package com.sntsb.groovy.playlist.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import com.sntsb.groovy.data.model.Playlist
import com.sntsb.groovy.data.repository.PlaylistRepository
import javax.inject.Inject

class PlaylistViewModel @Inject constructor(
    playlistRepository: PlaylistRepository
) : ViewModel() {

    val playlists = liveData<Result<List<Playlist>>> {
        emitSource(playlistRepository.getPlaylists().asLiveData())
    }

}
