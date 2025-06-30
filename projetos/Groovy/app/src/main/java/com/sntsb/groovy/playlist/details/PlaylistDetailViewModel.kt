package com.sntsb.groovy.playlist.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sntsb.groovy.data.services.PlaylistDetailsServiceImpl
import com.sntsb.groovy.domain.model.PlaylistDetail
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class PlaylistDetailViewModel(
    private val service: PlaylistDetailsServiceImpl
) : ViewModel() {

    val isLoading = MutableLiveData<Boolean>()

    val playlistDetails = MutableLiveData<Result<PlaylistDetail>>()
    fun getPlaylistDetails(id: String) {
        viewModelScope.launch {
            isLoading.postValue(true)

            service.fetchPlaylistDetails(id).onEach {
                    isLoading.postValue(false)
                }.collect { result ->
                    playlistDetails.postValue(result)
                }

        }
    }

}
