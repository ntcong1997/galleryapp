plugins {
    id("galleryapp.android.library")
    kotlin("kapt")
}

android {
    namespace = "com.fossil.galleryapp.core.domain"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:data"))
    implementation(project(":core:model"))

    // Coroutines
    implementation(libs.org.jetbrains.kotlinx.kotlinx.coroutines.android)

    // Paging
    implementation(libs.androidx.paging.paging.runtime)

    implementation(libs.com.google.dagger.hilt.android)
    kapt(libs.com.google.dagger.hilt.android.compiler)
}