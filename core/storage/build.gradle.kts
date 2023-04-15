plugins {
    id("galleryapp.android.library")
    id("galleryapp.android.hilt")
}

android {
    namespace = "com.fossil.galleryapp.core.storage"
}

dependencies {
//    implementation(project(":core:common"))

    // Coroutines
    implementation(libs.org.jetbrains.kotlinx.kotlinx.coroutines.android)
}