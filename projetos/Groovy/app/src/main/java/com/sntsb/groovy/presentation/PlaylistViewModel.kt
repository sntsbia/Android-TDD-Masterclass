package com.sntsb.groovy.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sntsb.groovy.data.model.Playlist
import com.sntsb.groovy.data.repository.PlaylistRepository

class PlaylistViewModel(
    playlistRepository: PlaylistRepository
) : ViewModel() {

    val playlists = MutableLiveData<Result<List<Playlist>>>()

    init {
        playlistRepository.getPlaylists()
    }

}
