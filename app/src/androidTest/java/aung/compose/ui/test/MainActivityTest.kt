package aung.compose.ui.test

import android.content.Intent
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(ExperimentalTestApi::class)
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Test
    fun hello() {
        runAndroidComposeUiTest<MainActivity>(
            Intent(ApplicationProvider.getApplicationContext(), MainActivity::class.java)
                .putExtra(Intent.EXTRA_TEXT, "hello")
        ) {
            onNodeWithText("hello").assertExists().assertIsDisplayed()
        }
    }

    @Test
    fun hi() {
        runAndroidComposeUiTest<MainActivity>(
            Intent(ApplicationProvider.getApplicationContext(), MainActivity::class.java)
                .putExtra(Intent.EXTRA_TEXT, "hi")
        ) {
            onNodeWithText("hi").assertExists().assertIsDisplayed()
        }
    }

    @Test
    fun myHello() {
        runAndroidComposeUiTest(
            activityLauncher = {
                ActivityScenario.launch<MainActivity>(
                    Intent(ApplicationProvider.getApplicationContext(), MainActivity::class.java)
                        .putExtra(Intent.EXTRA_TEXT, "hello")
                )
            }
        ) {
            onNodeWithText("hello").assertExists().assertIsDisplayed()
        }
    }

    @Test
    fun myHeya() {
        runAndroidComposeUiTest(
            activityLauncher = {
                ActivityScenario.launch<MainActivity>(
                    Intent(ApplicationProvider.getApplicationContext(), MainActivity::class.java)
                        .putExtra(Intent.EXTRA_TEXT, "hi")
                )
            }
        ) {
            onNodeWithText("hi").assertExists().assertIsDisplayed()
        }
    }
}