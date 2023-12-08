package io.github.aungthiha.compose.ui.test

import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.test.ext.junit.rules.ActivityScenarioRule

fun <A : ComponentActivity> createAndroidComposeRule(
    startActivityIntent: Intent
): AndroidComposeTestRule<ActivityScenarioRule<A>, A> = AndroidComposeTestRule(
    activityRule = ActivityScenarioRule(startActivityIntent),
    activityProvider = ::getActivityFromTestRule
)

private fun <A : ComponentActivity> getActivityFromTestRule(rule: ActivityScenarioRule<A>): A {
    var activity: A? = null
    rule.scenario.onActivity { activity = it }
    if (activity == null) {
        throw IllegalStateException("Activity was not set in the ActivityScenarioRule!")
    }
    return activity!!
}