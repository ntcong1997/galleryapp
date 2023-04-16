plugins {
    id("galleryapp.android.library")
    id("galleryapp.android.hilt")
}

android {
    namespace = "com.fossil.galleryapp.core.storage"
}

dependencies {
    implementation(project(":core:model"))

    // Coroutines
    implementation(libs.org.jetbrains.kotlinx.kotlinx.coroutines.android)

    // Paging
    implementation(libs.androidx.paging.paging.runtime)
}