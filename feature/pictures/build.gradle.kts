plugins {
    id("galleryapp.android.feature")
    id("galleryapp.android.library.compose")
}

android {
    namespace = "com.fossil.galleryapp.feature.pictures"
}

dependencies {
    // Paging
    implementation(libs.androidx.paging.paging.runtime)
    implementation(libs.androidx.paging.paging.compose)
}