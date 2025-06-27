package com.sntsb.groovy.playlist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import com.sntsb.groovy.data.repository.PlaylistRepository
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class PlaylistViewModel @Inject constructor(
    playlistRepository: PlaylistRepository
) : ViewModel() {

    val isLoading = MutableLiveData<Boolean>()

    val playlists = liveData {
        isLoading.postValue(true)

        emitSource(playlistRepository.getPlaylists().onEach {
            isLoading.postValue(false)
        }.asLiveData())
    }

}
