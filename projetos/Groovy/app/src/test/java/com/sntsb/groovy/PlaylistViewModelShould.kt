package com.sntsb.groovy

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.sntsb.groovy.data.repository.PlaylistRepositoryImpl
import com.sntsb.groovy.presentation.PlaylistViewModel
import com.sntsb.groovy.utils.MainCoroutineScopeRule
import com.sntsb.groovy.utils.getValueForTest
import org.junit.Rule
import org.junit.Test

class PlaylistViewModelShould {

    @get: Rule
    var coroutinesTestRule = MainCoroutineScopeRule()

    @get: Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val viewModel: PlaylistViewModel
    private val repository: PlaylistRepositoryImpl = mock()

    init {
        viewModel = PlaylistViewModel(repository)
    }


    @Test
    fun getPlaylistsFromRepository() {
        viewModel.playlists.getValueForTest()

        verify(repository, times(1)).getPlaylists()
    }
}