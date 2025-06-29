package com.sntsb.groovy

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.adevinta.android.barista.assertion.BaristaRecyclerViewAssertions.assertRecyclerViewItemCount
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertNotDisplayed
import com.adevinta.android.barista.internal.matcher.DrawableMatcher.Companion.withDrawable
import com.sntsb.groovy.utils.BaseUITest
import org.hamcrest.core.IsNot.not
import org.junit.Test

class PlaylistFeature : BaseUITest() {

    @Test
    fun displayScreenTitle() {
        assertDisplayed("Playlists")
    }

    @Test
    fun displaysListOfPlaylists() {
        onView(withId(R.id.progress_bar)).check(matches(not(isDisplayed())))

        assertRecyclerViewItemCount(R.id.list, 10)

        onView(
            withinNstPlaylistItem(
                withId(R.id.tv_name), 0
            )
        ).check(matches(withText("Hard Rock Cafe"))).check(matches(isDisplayed()))

        onView(withinNstPlaylistItem(withId(R.id.tv_category), 0)).check(matches(withText("rock")))
            .check(matches(isDisplayed()))

        onView(
            withinNstPlaylistItem(
                withId(R.id.iv_image), 0
            )
        ).check(matches(withDrawable(R.mipmap.playlist))).check(matches(isDisplayed()))

    }

    @Test
    fun displaysLoadingIndicatorWhileFetchingThePlaylists() {
        assertDisplayed(R.id.progress_bar)
    }

    @Test
    fun hidesLoadingIndicatorAfterFetchingThePlaylists() {
        onView(withId(R.id.progress_bar)).check(matches(not(isDisplayed())))

        assertNotDisplayed(R.id.progress_bar)
    }

    @Test
    fun displaysRockImageForRockListItems() {
        onView(
            withinNstPlaylistItem(
                withId(R.id.iv_image), 0
            )
        ).check(matches(withDrawable(R.mipmap.rock))).check(matches(isDisplayed()))

        onView(
            withinNstPlaylistItem(
                withId(R.id.iv_image), 3
            )
        ).check(matches(withDrawable(R.mipmap.rock))).check(matches(isDisplayed()))
    }

    @Test
    fun navigateToDetailsScreen() {
        onView(
            withinNstPlaylistItem(
                withId(R.id.iv_image), 0
            )
        ).perform(click())
        assertDisplayed(R.id.playlist_details_root)
    }
}