plugins {
    id("galleryapp.android.application")
    id("galleryapp.android.application.compose")
    id("galleryapp.android.hilt")
}

android {
    defaultConfig {
        applicationId = "com.fossil.galleryapp"
        versionCode = 1
        versionName = "0.0.1" // X.Y.Z; X = Major, Y = minor, Z = Patch level

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        val release by getting {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    namespace = "com.fossil.galleryapp"
}

dependencies {
    implementation(project(":feature:pictures"))
    implementation(project(":feature:videos"))

    implementation(project(":core:common"))
    implementation(project(":core:designsystem"))

    // Dagger Hilt
    implementation(libs.androidx.hilt.hilt.navigation.compose)
    androidTestImplementation(libs.com.google.dagger.hilt.android.testing)

    // Lifecycle
    implementation(libs.androidx.lifecycle.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.lifecycle.viewmodel.compose)

    // Navigation
    implementation(libs.androidx.navigation.navigation.compose)
    androidTestImplementation(libs.androidx.navigation.navigation.testing)

    // Splash screen
    implementation(libs.androidx.core.core.splashscreen)

    // Utils
    implementation(libs.androidx.tracing.tracing.ktx)

    androidTestImplementation(libs.androidx.compose.ui.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.ui.test.manifest)
}