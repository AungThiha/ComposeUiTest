// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("io.github.gradle-nexus.publish-plugin") version "1.3.0"
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
}

apply(from = "${rootDir}/scripts/publisher.gradle")
