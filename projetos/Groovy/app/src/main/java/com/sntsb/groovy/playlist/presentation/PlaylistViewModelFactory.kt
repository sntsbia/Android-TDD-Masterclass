package com.sntsb.groovy.playlist.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sntsb.groovy.data.repository.PlaylistRepository
import javax.inject.Inject

class PlaylistViewModelFactory @Inject constructor(
    private val playlistRepository: PlaylistRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PlaylistViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST") return PlaylistViewModel(playlistRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
