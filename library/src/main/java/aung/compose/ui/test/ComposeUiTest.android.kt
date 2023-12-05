/**
 * Author: Aung Thiha
 * https://www.linkedin.com/in/a1992/
 *
 * An Android engineer dedicated to empowering fellow engineers and the broader tech community
 * while delivering valuable solutions to users and equipping internal teams with essential tools,
 * including analytical dashboards for observability, a streamlined CI/CD pipeline,
 * in-house Android libraries, and comprehensive documentation.
 *
 * Code in this file is written based on the code from
 * https://github.com/androidx/androidx/blob/androidx-main/compose/ui/ui-test-junit4/src/androidMain/kotlin/androidx/compose/ui/test/ComposeUiTest.android.kt
 */
package aung.compose.ui.test

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.ui.test.AndroidComposeUiTest
import androidx.compose.ui.test.AndroidComposeUiTestEnvironment
import androidx.compose.ui.test.ComposeUiTest
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.runComposeUiTest
import androidx.test.core.app.ActivityScenario
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

/**
 * Variant of [runComposeUiTest] that allows you to specify which Activity should be launched.
 * Be aware that if the Activity [sets content][androidx.activity.compose.setContent] during its
 * launch, you cannot use [setContent][ComposeUiTest.setContent] on the ComposeUiTest anymore as
 * this would override the content and can lead to subtle bugs.
 *
 * @param A The Activity type to be launched, which typically (but not necessarily) hosts the
 * Compose content
 * @param activityClass an activity class to launch
 * @param effectContext The [CoroutineContext] used to run the composition. The context for
 * `LaunchedEffect`s and `rememberCoroutineScope` will be derived from this context.
 * @param block The test function.
 * @throws AssertionError if the lifecycle state transition never completes within the timeout
 * @return ActivityScenario which you can use to make further state transitions
 */
@ExperimentalTestApi
fun <A : ComponentActivity> runAndroidComposeUiTest(
    activityClass: Class<A>,
    effectContext: CoroutineContext = EmptyCoroutineContext,
    block: AndroidComposeUiTest<A>.() -> Unit
) {
    runAndroidComposeUiTest(
        activityLauncher = {
            ActivityScenario.launch(activityClass)
        },
        effectContext = effectContext,
        block = block
    )
}

/**
 * Variant of [runComposeUiTest] that allows you to specify which Activity should be launched
 * and also lets you pass in activity options bundle.
 * Be aware that if the Activity [sets content][androidx.activity.compose.setContent] during its
 * launch, you cannot use [setContent][ComposeUiTest.setContent] on the ComposeUiTest anymore as
 * this would override the content and can lead to subtle bugs.
 *
 * @param A The Activity type to be launched, which typically (but not necessarily) hosts the
 * Compose content
 * @param activityClass an activity class to launch
 * @param activityOptions an activity options bundle to be passed along with the intent to start
 * activity.
 * @param effectContext The [CoroutineContext] used to run the composition. The context for
 * `LaunchedEffect`s and `rememberCoroutineScope` will be derived from this context.
 * @param block The test function.
 * @throws AssertionError if the lifecycle state transition never completes within the timeout
 * @return ActivityScenario which you can use to make further state transitions
 */
@ExperimentalTestApi
fun <A : ComponentActivity> runAndroidComposeUiTest(
    activityClass: Class<A>,
    activityOptions: Bundle,
    effectContext: CoroutineContext = EmptyCoroutineContext,
    block: AndroidComposeUiTest<A>.() -> Unit
) {
    runAndroidComposeUiTest(
        activityLauncher = {
            ActivityScenario.launch(activityClass, activityOptions)
        },
        effectContext = effectContext,
        block = block
    )
}

/**
 * Variant of [runComposeUiTest] that Launches an activity by a given intent
 * Be aware that if the Activity [sets content][androidx.activity.compose.setContent] during its
 * launch, you cannot use [setContent][ComposeUiTest.setContent] on the ComposeUiTest anymore as
 * this would override the content and can lead to subtle bugs.
 *
 * @param A The Activity type to be launched, which typically (but not necessarily) hosts the
 * Compose content
 * @param startActivityIntent an intent to start the activity
 * @param effectContext The [CoroutineContext] used to run the composition. The context for
 * `LaunchedEffect`s and `rememberCoroutineScope` will be derived from this context.
 * @param block The test function.
 * @throws AssertionError if the lifecycle state transition never completes within the timeout
 * @return ActivityScenario which you can use to make further state transitions
 */
@ExperimentalTestApi
fun <A : ComponentActivity> runAndroidComposeUiTest(
    startActivityIntent: Intent,
    effectContext: CoroutineContext = EmptyCoroutineContext,
    block: AndroidComposeUiTest<A>.() -> Unit
) {
    runAndroidComposeUiTest(
        activityLauncher = {
            ActivityScenario.launch(startActivityIntent)
        },
        effectContext = effectContext,
        block = block
    )
}

/**
 * Variant of [runComposeUiTest] that Launches an activity by a given intent and activity options
 * Be aware that if the Activity [sets content][androidx.activity.compose.setContent] during its
 * launch, you cannot use [setContent][ComposeUiTest.setContent] on the ComposeUiTest anymore as
 * this would override the content and can lead to subtle bugs.
 *
 * @param A The Activity type to be launched, which typically (but not necessarily) hosts the
 * Compose content
 * @param startActivityIntent an intent to start the activity
 * @param activityOptions an activity options bundle to be passed along with the intent to start
 * activity.
 * @param effectContext The [CoroutineContext] used to run the composition. The context for
 * `LaunchedEffect`s and `rememberCoroutineScope` will be derived from this context.
 * @param block The test function.
 * @throws AssertionError if the lifecycle state transition never completes within the timeout
 * @return ActivityScenario which you can use to make further state transitions
 */
@ExperimentalTestApi
fun <A : ComponentActivity> runAndroidComposeUiTest(
    startActivityIntent: Intent,
    activityOptions: Bundle,
    effectContext: CoroutineContext = EmptyCoroutineContext,
    block: AndroidComposeUiTest<A>.() -> Unit
) {
    runAndroidComposeUiTest(
        activityLauncher = {
            ActivityScenario.launch(startActivityIntent, activityOptions)
        },
        effectContext = effectContext,
        block = block
    )
}

/**
 * Variant of [runComposeUiTest] that allows you to specify how Activity should be launched.
 * Be aware that if the Activity [sets content][androidx.activity.compose.setContent] during its
 * launch, you cannot use [setContent][ComposeUiTest.setContent] on the ComposeUiTest anymore as
 * this would override the content and can lead to subtle bugs.
 *
 * @param activityLauncher a function that's called to launch an Activity right before the test function runs
 * @param effectContext The [CoroutineContext] used to run the composition. The context for
 * `LaunchedEffect`s and `rememberCoroutineScope` will be derived from this context.
 * @param block The test function.
 */
@ExperimentalTestApi
fun <A : ComponentActivity> runAndroidComposeUiTest(
    activityLauncher: () -> ActivityScenario<A>,
    effectContext: CoroutineContext = EmptyCoroutineContext,
    block: AndroidComposeUiTest<A>.() -> Unit
) {
    // Don't start the scenario now, wait until we're inside runTest { },
    // in case the Activity's onCreate/Start/Resume calls setContent
    var scenario: ActivityScenario<A>? = null
    val environment = AndroidComposeUiTestEnvironment(effectContext) {
        requireNotNull(scenario) {
            "ActivityScenario has not yet been launched, or has already finished. Make sure that " +
                    "any call to ComposeUiTest.setContent() and AndroidComposeUiTest.getActivity() " +
                    "is made within the lambda passed to AndroidComposeUiTestEnvironment.runTest()"
        }.getActivity()
    }
    try {
        environment.runTest {
            scenario = activityLauncher()
            block()
        }
    } finally {
        // Close the scenario outside runTest to avoid getting stuck.
        //
        // ActivityScenario.close() calls Instrumentation.waitForIdleSync(), which would time out
        // if there is an infinite self-invalidating measure, layout, or draw loop. If the
        // Compose content was set through the test's setContent method, it will remove the
        // AndroidComposeView from the view hierarchy which breaks this loop, which is why we
        // call close() outside the runTest lambda. This will not help if the content is not set
        // through the test's setContent method though, in which case we'll still time out here.
        scenario?.close()
    }
}

internal fun <A : ComponentActivity> ActivityScenario<A>.getActivity(): A? {
    var activity: A? = null
    onActivity { activity = it }
    return activity
}