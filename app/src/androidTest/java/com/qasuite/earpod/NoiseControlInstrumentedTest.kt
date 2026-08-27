package com.qasuite.earpod

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NoiseControlInstrumentedTest {

    @Test
    fun ancMode_canBeSelected() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.switch_anc)).perform(click())
        onView(withId(R.id.current_mode)).check(matches(withText("Current mode: ANC")))
    }

    @Test
    fun transparencyMode_canBeSelected() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.switch_transparency)).perform(click())
        onView(withId(R.id.current_mode)).check(matches(withText("Current mode: Transparency")))
    }

    @Test
    fun noiseModes_areMutuallyExclusive() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.switch_anc)).perform(click())
        onView(withId(R.id.switch_transparency)).perform(click())

        onView(withId(R.id.switch_transparency)).check(matches(isChecked()))
        onView(withId(R.id.switch_anc)).check(matches(isNotChecked()))
    }
}
