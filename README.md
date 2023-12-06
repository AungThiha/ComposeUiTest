# ComposeUiTest
A tool to launch an activity with intent in instrumented test and assert composables in the activity, solving the limitation of ComposeTestRule that does not accept an intent as an input for launching activities.

This will be available in maven central before the end of Dec 2023 but for now, if you wanna use it, you can copy `ComposeUiTest.android.kt` and paste it into your project to use it.

Sample usages can be found in `MainActivityTest.kt`
