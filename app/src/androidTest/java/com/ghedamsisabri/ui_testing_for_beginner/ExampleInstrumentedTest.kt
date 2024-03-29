package com.ghedamsisabri.ui_testing_for_beginner

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.ghedamsisabri.ui_testing_for_beginner.Helper.assertIsViewDisplayed
import com.ghedamsisabri.ui_testing_for_beginner.Helper.isTextOnScreen
import com.ghedamsisabri.ui_testing_for_beginner.Helper.tap
import org.hamcrest.Matcher

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule


@RunWith(AndroidJUnit4::class)
@LargeTest
class ExampleInstrumentedTest {

    @get:Rule var activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun checkSecondPage() {
        mainPageTextView.assertIsViewDisplayed()
        NextBtn.tap()
        isTextOnScreen("SecondaryActivity")
        secondPageActivity.assertIsViewDisplayed()
        backButton.assertIsViewDisplayed()

    }
    @Test
    fun checkFirstPage(){
        mainPageTextView.assertIsViewDisplayed()
        NextBtn.tap()
        backButton.tap()
        isTextOnScreen("MainActivity")
        firstPageText.assertIsViewDisplayed()
        NextBtn.assertIsViewDisplayed()

    }

    companion object{
        val NextBtn: Matcher<View> by lazy { withId(R.id.button_next_activity) }
        val secondPageActivity: Matcher<View> by lazy { withId(R.id.activity_secondary_title) }
        val mainPageTextView: Matcher<View> by lazy {withId(R.id.main)}
        val backButton: Matcher<View> by lazy { withId(R.id.button_back) }
        val firstPageText: Matcher<View> by lazy { withId(R.id.activity_main_title) }
    }
}