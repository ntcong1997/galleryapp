plugins {
    id("galleryapp.android.library")
    id("galleryapp.android.hilt")
}

android {
    namespace = "com.fossil.galleryapp.core.data"
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:storage"))

    // Paging
    implementation(libs.androidx.paging.paging.runtime)
}