package com.sntsb.groovy

import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.adevinta.android.barista.assertion.BaristaRecyclerViewAssertions.assertRecyclerViewItemCount
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertNotDisplayed
import com.adevinta.android.barista.internal.matcher.DrawableMatcher.Companion.withDrawable
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.AllOf.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PlaylistFeature {

    val mActivityRule = ActivityScenarioRule(MainActivity::class.java)
        @Rule get

    private fun withinNstPlaylistItem(
        targetViewMatcher: Matcher<View>,
        position: Int
    ): Matcher<View> {
        return allOf(
            targetViewMatcher, isDescendantOfA(nthChildOf(withId(R.id.list), position))
        )
    }

    @Test
    fun displayScreenTitle() {
        assertDisplayed("Playlists")
    }

    @Test
    fun displaysListOfPlaylists() {
        Thread.sleep(4000)
        assertRecyclerViewItemCount(R.id.list, 10)

        onView(
            withinNstPlaylistItem(
                withId(R.id.tv_name),
                0
            )
        ).check(matches(withText("Hard Rock Cafe"))).check(matches(isDisplayed()))

        onView(withinNstPlaylistItem(withId(R.id.tv_category), 0)).check(matches(withText("rock")))
            .check(matches(isDisplayed()))

        onView(
            withinNstPlaylistItem(
                withId(R.id.iv_image),
                0
            )
        ).check(matches(withDrawable(R.mipmap.playlist))).check(matches(isDisplayed()))

    }

    @Test
    fun displaysLoadingIndicatorWhileFetchingThePlaylists() {
        assertDisplayed(R.id.progress_bar)
    }

    @Test
    fun hidesLoadingIndicatorAfterFetchingThePlaylists() {
        Thread.sleep(4000)
        assertNotDisplayed(R.id.progress_bar)
    }

    @Test
    fun displaysRockImageForRockListItems() {
        onView(
            withinNstPlaylistItem(
                withId(R.id.iv_image),
                0
            )
        ).check(matches(withDrawable(R.mipmap.rock))).check(matches(isDisplayed()))

        onView(
            withinNstPlaylistItem(
                withId(R.id.iv_image),
                3
            )
        ).check(matches(withDrawable(R.mipmap.rock))).check(matches(isDisplayed()))
    }

    private fun nthChildOf(parentMatcher: Matcher<View>, childPosition: Int): Matcher<View> {
        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("position $childPosition of parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                if (view.parent !is ViewGroup) return false
                val parent = view.parent as ViewGroup

                return (parentMatcher.matches(parent) && parent.childCount > childPosition && parent.getChildAt(
                    childPosition
                ) == view)
            }
        }
    }
}