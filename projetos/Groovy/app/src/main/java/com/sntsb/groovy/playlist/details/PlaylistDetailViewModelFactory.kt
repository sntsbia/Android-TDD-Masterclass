package com.sntsb.groovy.playlist.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sntsb.groovy.data.services.PlaylistDetailsServiceImpl
import javax.inject.Inject

class PlaylistDetailViewModelFactory @Inject constructor(private val service: PlaylistDetailsServiceImpl) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PlaylistDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST") return PlaylistDetailViewModel(service) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
