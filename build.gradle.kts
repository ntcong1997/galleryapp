// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    alias(libs.plugins.com.android.application) apply false
    alias(libs.plugins.org.jetbrains.kotlin.jvm) apply false
    alias(libs.plugins.com.google.dagger.hilt.android) apply false
    id("com.android.library") version "7.4.1" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
}