package com.sntsb.groovy.details

import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.sntsb.groovy.data.services.PlaylistDetailsServiceImpl
import com.sntsb.groovy.domain.model.PlaylistDetail
import com.sntsb.groovy.playlist.details.PlaylistDetailViewModel
import com.sntsb.groovy.utils.BaseUnitTest
import com.sntsb.groovy.utils.getValueForTest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito.mock

class PlaylistDetailViewModelShould : BaseUnitTest() {

    private val service: PlaylistDetailsServiceImpl = mock()

    private val id = "1"
    private val playlistDetail = mock<PlaylistDetail>()

    private val expected = Result.success(playlistDetail)
    private val exception = Result.failure<PlaylistDetail>(Exception("Something went wrong"))

    fun callSuccessfulCaseViewModel(): PlaylistDetailViewModel {
        runBlocking {
            whenever(service.fetchPlaylistDetails(id)).thenReturn(
                flow {
                    emit(expected)
                })
        }
        return PlaylistDetailViewModel(service)
    }

    fun callFailureCaseViewModel(): PlaylistDetailViewModel {
        runBlocking {
            whenever(service.fetchPlaylistDetails(id)).thenReturn(
                flow {
                    emit(exception)
                })
        }
        return PlaylistDetailViewModel(service)
    }


    @Test
    fun getPlaylistDetailFromService() = runTest {

        val viewModel = callSuccessfulCaseViewModel()

        viewModel.getPlaylistDetails(id)

        viewModel.playlistDetails.getValueForTest()

        verify(service, times(1)).fetchPlaylistDetails(id)

    }

    @Test
    fun emitPlaylistDetailFromService() = runTest {
        val viewModel = callSuccessfulCaseViewModel()

        viewModel.getPlaylistDetails(id)

        Assert.assertEquals(
            expected, viewModel.playlistDetails.getValueForTest()
        )
    }

    @Test
    fun emitErrorWhenServiceFails() = runTest {

        val viewModel = callFailureCaseViewModel()

        viewModel.getPlaylistDetails(id)

        Assert.assertEquals(
            exception, viewModel.playlistDetails.getValueForTest()
        )
    }

}