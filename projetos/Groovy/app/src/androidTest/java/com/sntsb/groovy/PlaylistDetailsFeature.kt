package com.sntsb.groovy

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.sntsb.groovy.utils.BaseUITest
import org.junit.Test

class PlaylistDetailsFeature : BaseUITest() {

    fun openFirstPlaylistItemDetails() {
        onView(
            withinNstPlaylistItem(
                withId(R.id.iv_image), 0
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
}