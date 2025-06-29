package com.sntsb.groovy.playlist.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sntsb.groovy.data.services.PlaylistDetailsServiceImpl
import com.sntsb.groovy.domain.model.PlaylistDetail
import kotlinx.coroutines.launch

class PlaylistDetailViewModel(
    private val service: PlaylistDetailsServiceImpl
) : ViewModel() {

    val isLoading = MutableLiveData<Boolean>()

    val playlistDetails = MutableLiveData<Result<PlaylistDetail>>()
    fun getPlaylistDetails(id: String) {
        isLoading.postValue(true)

        viewModelScope.launch {
            service.fetchPlaylistDetails(id).collect { result ->
                    playlistDetails.postValue(result)
                    isLoading.postValue(false)
                }

        }

    }

}
