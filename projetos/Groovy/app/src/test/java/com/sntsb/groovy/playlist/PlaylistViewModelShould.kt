package com.sntsb.groovy.playlist

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.sntsb.groovy.data.model.Playlist
import com.sntsb.groovy.data.repository.PlaylistRepositoryImpl
import com.sntsb.groovy.playlist.presentation.PlaylistViewModel
import com.sntsb.groovy.utils.BaseUnitTest
import com.sntsb.groovy.utils.captureValues
import com.sntsb.groovy.utils.getValueForTest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

class PlaylistViewModelShould : BaseUnitTest() {

    private val repository: PlaylistRepositoryImpl = mock()

    private val playlists = mock<List<Playlist>>()
    private val expected = Result.success(playlists)
    private val exception = Result.failure<List<Playlist>>(Exception("Something went wrong"))

    private fun callSuccessfulCaseViewModel(): PlaylistViewModel {
        runBlocking {
            whenever(repository.getPlaylists()).thenReturn(
                flow {
                    emit(expected)
                })
        }

        return PlaylistViewModel(repository)
    }

    private fun callFailureCaseViewModel(): PlaylistViewModel {

        runBlocking {
            whenever(repository.getPlaylists()).thenReturn(
                flow {
                    emit(exception)
                })
        }

        return PlaylistViewModel(repository)
    }

    @Test
    fun getPlaylistsFromRepository() = runTest {

        val viewModel = callSuccessfulCaseViewModel()

        viewModel.playlists.getValueForTest()

        verify(repository, times(1)).getPlaylists()
    }

    @Test
    fun emitErrorWhenRepositoryFails() = runTest {

        val viewModel = callFailureCaseViewModel()

        Assert.assertEquals(exception, viewModel.playlists.getValueForTest())
    }

    @Test
    fun emitPlaylistsFromRepository() = runTest {
        val viewModel = callSuccessfulCaseViewModel()

        Assert.assertEquals(expected, viewModel.playlists.getValueForTest())
    }

    enum class SearchEnum {
        FIRST, LAST
    }

    private fun validateIsLoadingState(
        viewModel: PlaylistViewModel, expected: Boolean, search: SearchEnum
    ) = runTest {
        viewModel.isLoading.captureValues {
            viewModel.playlists.getValueForTest()
            when (search) {
                SearchEnum.FIRST -> Assert.assertEquals(expected, values[0])
                SearchEnum.LAST -> Assert.assertEquals(expected, values.last())
            }
        }
    }

    @Test
    fun showLoadingStateWhenFetchingPlaylists() = runTest {
        val viewModel = callSuccessfulCaseViewModel()

        validateIsLoadingState(viewModel, true, SearchEnum.FIRST)

    }

    @Test
    fun hideLoadingStateAfterFetchingPlaylists() = runTest {
        val viewModel = callSuccessfulCaseViewModel()

        validateIsLoadingState(viewModel, false, SearchEnum.LAST)

    }

    @Test
    fun hideLoadingStateWhenFetchingPlaylistsFails() = runTest {
        val viewModel = callFailureCaseViewModel()

        validateIsLoadingState(viewModel, false, SearchEnum.LAST)
    }
}