package com.sntsb.groovy.utils

import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sntsb.groovy.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.AllOf.allOf
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
abstract class BaseUITest {

//    @Before
//    fun setup() {
//        IdlingRegistry.getInstance().register(EspressoIdlingResource.countingIdlingResource)
//    }
//
//    @After
//    fun tearDown() {
//        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.countingIdlingResource)
//    }

    fun withinNstPlaylistItem(
        targetViewMatcher: Matcher<View>, position: Int
    ): Matcher<View> {
        return allOf(
            targetViewMatcher, isDescendantOfA(nthChildOf(withId(R.id.list), position))
        )
    }

    fun nthChildOf(parentMatcher: Matcher<View>, childPosition: Int): Matcher<View> {
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