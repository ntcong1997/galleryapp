plugins {
    id("galleryapp.android.library")
    id("galleryapp.android.library.compose")
}

android {
    namespace = "com.fossil.galleryapp.core.ui"
}

dependencies {
    implementation(project(":core:designsystem"))
    implementation(project(":core:model"))

    implementation(libs.androidx.core.core.ktx)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.ui.ui.tooling)
    implementation(libs.androidx.compose.ui.ui.tooling.preview)

    // Coil
    implementation(libs.io.coil.kt)
    implementation(libs.io.coil.kt.video)
    implementation(libs.io.coil.kt.compose)

    // Paging
    implementation(libs.androidx.paging.paging.compose)
}