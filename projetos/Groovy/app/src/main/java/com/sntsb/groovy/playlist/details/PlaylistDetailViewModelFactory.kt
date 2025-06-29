package com.sntsb.groovy.playlist.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class PlaylistDetailViewModelFactory @Inject constructor() : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PlaylistDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST") return PlaylistDetailViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
