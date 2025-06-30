package com.sntsb.groovy

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertNotDisplayed
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertNotExist
import com.sntsb.groovy.utils.BaseUITest
import org.hamcrest.core.IsNot.not
import org.junit.Test

class PlaylistDetailsFeature : BaseUITest() {

    fun openFirstPlaylistItemDetails() {
        onView(
            withinNstPlaylistItem(
                withId(R.id.iv_image), 0
            )
        ).perform(click())
    }

    fun openSecondPlaylistItemDetails() {
        onView(
            withinNstPlaylistItem(
                withId(R.id.iv_image), 1
            )
        ).perform(click())
    }

    @Test
    fun displayScreenTitle() {
        assertDisplayed("Playlists")
    }

    @Test
    fun displaysPlaylistNameAndDetails() {

        openFirstPlaylistItemDetails()

        assertDisplayed(R.id.playlist_name)
        assertDisplayed("Hard Rock Cafe")

        assertDisplayed(R.id.playlist_details)
        assertDisplayed("Rock your senses with this timeless signature vibe list. \n\n • Poison \n • You shook me all night \n • Zombie \n • Rock'n Me \n • Thunderstruck \n • I Hate Myself for Loving you \n • Crazy \n • Knockin' on Heavens Door")

    }

    @Test
    fun displaysLoadingIndicator() {
        Thread.sleep(3000)

        openFirstPlaylistItemDetails()

        assertDisplayed(R.id.detail_progress_bar)
    }

    @Test
    fun displaysErrorMessageWhenNetworkFails() {

        openSecondPlaylistItemDetails()

        assertDisplayed(R.string.generic_error_message)
    }

    @Test
    fun hidesErrorMessageWhenNetworkFails() {

        openSecondPlaylistItemDetails()

        Thread.sleep(3000)

        assertNotExist(R.string.generic_error_message)
    }


    @Test
    fun hidesLoadingIndicatorAfterFetchingThePlaylists() {

        onView(withId(R.id.detail_progress_bar)).check(matches(not(isDisplayed())))

        assertNotDisplayed(R.id.detail_progress_bar)
    }


}