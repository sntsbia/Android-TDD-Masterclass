package com.sntsb.groovy.details

import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.sntsb.groovy.data.services.PlaylistDetailsServiceImpl
import com.sntsb.groovy.domain.model.PlaylistDetail
import com.sntsb.groovy.playlist.details.PlaylistDetailViewModel
import com.sntsb.groovy.utils.BaseUnitTest
import com.sntsb.groovy.utils.getValueForTest
import org.junit.Test
import org.mockito.Mockito.mock

class PlaylistDetailViewModelShould : BaseUnitTest() {

    private val service: PlaylistDetailsServiceImpl = mock()

    lateinit var viewModel: PlaylistDetailViewModel

    private val id = "1"
    private val playlistDetail = mock<PlaylistDetail>()

    private val expected = Result.success(playlistDetail)
    private val exception = Result.failure<PlaylistDetail>(Exception("Something went wrong"))

    @Test
    fun getPlaylistDetailFromService() {

        viewModel.getPlaylistDetails(id)

        viewModel.playlistDetails.getValueForTest()

        verify(service, times(1)).fetchPlaylistDetails(id)

    }

}