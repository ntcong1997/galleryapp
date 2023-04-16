plugins {
    id("galleryapp.android.library")
    id("galleryapp.android.library.compose")
}

android {
    namespace = "com.fossil.galleryapp.core.designsystem"
}

dependencies {
    // Core
    implementation(libs.androidx.core.core.ktx)

    // Compose
    api(libs.androidx.compose.material)
    implementation(libs.androidx.compose.material.material.icons.extended)
    api(libs.androidx.compose.ui)
    api(libs.androidx.compose.ui.ui.tooling)
    api(libs.androidx.compose.ui.ui.tooling.preview)
}