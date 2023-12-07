# ComposeUiTest
A tool to launch an activity with intent in instrumented tests and assert composables in the activity, solving the limitation of ComposeTestRule that does not accept an intent as an input for launching activities.
# Download
```kotlin
dependencies {
    androidTestImplementation("io.github.aungthiha:compose-ui-test:1.0.0")
}
```
# Usage With Intent
`runAndroidComposeUiTest` uses `ActivityScenario` internally to launch an Activity
```kotlin
runAndroidComposeUiTest<YourActivity>(
    startActivityIntent = Intent(
        ApplicationProvider.getApplicationContext(),
        MainActivity::class.java
    ).putExtra("key", "value")
) {
    // assert composables
    // example assertion below
    // onNodeWithText("hello").assertExists().assertIsDisplayed()
}
```
# Usage With ActivityScenario
You can also directly use `ActivityScenario` to launch an Activity the way you prefer
```kotlin
runAndroidComposeUiTest(
    activityLauncher = {
        ActivityScenario.launch<YourActivity>(
            Intent(ApplicationProvider.getApplicationContext(), YourActivity::class.java)
                .putExtra("key", "value"),
            Bundle().apply {
                putString("key", "value")
            }
        )
    }
) {
    // assert composables
}
```
