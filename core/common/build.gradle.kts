plugins {
    id("galleryapp.android.library")
    id("galleryapp.android.hilt")
}

android {
    namespace = "com.fossil.galleryapp.core.common"
}

dependencies {
    // Coroutines
    implementation(libs.org.jetbrains.kotlinx.kotlinx.coroutines.android)
}