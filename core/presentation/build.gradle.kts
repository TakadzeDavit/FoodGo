plugins {
    alias(libs.plugins.foodgo.android.library)
    alias(libs.plugins.foodgo.android.compose)
    alias(libs.plugins.koin.compiler)
}

android {
    namespace = "com.space.core.presentation"
}

dependencies {
    implementation(libs.bundles.koin)
    implementation(projects.core.navigation)
}