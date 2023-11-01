package com.slayton.msu.criminalintent

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import org.junit.Assert.*
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread

import org.junit.After
import org.junit.Before
import org.junit.Test

class CrimeDetailsFragmentTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun changesInViewsReflectedInCrimeObject() {

        val fragmentScenario = launchFragmentInContainer<CrimeDetailsFragment>()
        val extectedTitle = "Title!"
        val expectedIsSovled = true
        //perform a text change on the EditText view
        onView(withId(R.id.crime_title)).perform(typeText("Title!"))
        //perform a check on the CheckBox view
        onView(withId(R.id.crime_solved)).perform(click())

        fragmentScenario.onFragment { fragment ->
            //grab the properties' actual values
            val actualTitle = fragment.crime.title
            val actualIsSolved = fragment.crime.isSolved

            //assert that the expected values and the actual values match
            assertEquals(extectedTitle, actualTitle)
            assertEquals(expectedIsSovled, actualIsSolved)
        }
    }

    // explain help from chatGPT
}