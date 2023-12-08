package io.github.aungthiha.compose.ui.test

import android.content.Intent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityComposeRuleTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>(
        Intent(ApplicationProvider.getApplicationContext(), MainActivity::class.java)
            .putExtra(Intent.EXTRA_TEXT, "hello")
    )

    @Test
    fun hello() {
        composeTestRule.onNodeWithText("hello").assertExists().assertIsDisplayed()
    }

}