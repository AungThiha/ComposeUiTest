# ComposeUiTest
A tool to launch an activity with intent in instrumented tests and assert composables in the activity, solving the limitation of ComposeTestRule that does not accept an intent as an input for launching activities. 
Read [the medium article](https://medium.com/@AungThiha3/jetpack-compose-assert-intent-data-consumption-in-instrumented-tests-5c999d42aee8) to understand why this is essential.

## Download
```kotlin
dependencies {
    androidTestImplementation("io.github.aungthiha:compose-ui-test:1.0.1")
}
```
## Usage With Intent
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
## Usage With ActivityScenario
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

## Usage as TestRule
This is a good way if you want to launch the activity the same way for all your test cases. 
This `createAndroidComposeRule` function is written using the idea from [Michal Moczulski](https://gist.github.com/mrmike/3c4f4785dfb7477228d2dc9b872715ae)
```kotlin
@get:Rule
val composeTestRule = createAndroidComposeRule<YourActivity>(
    Intent(ApplicationProvider.getApplicationContext(), MainActivity::class.java)
        .putExtra("key", "value")
)
```
