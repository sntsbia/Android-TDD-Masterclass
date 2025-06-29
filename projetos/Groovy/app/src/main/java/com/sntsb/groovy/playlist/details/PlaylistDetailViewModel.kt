package com.sntsb.groovy.playlist.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sntsb.groovy.domain.model.PlaylistDetail

class PlaylistDetailViewModel : ViewModel() {

    val isLoading = MutableLiveData<Boolean>()

    val playlistDetails = MutableLiveData<Result<PlaylistDetail>>()
    fun getPlaylistDetails(id: String) {
        TODO("Implement fetching playlist details by ID")
    }

}
