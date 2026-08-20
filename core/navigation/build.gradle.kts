plugins {
    alias(libs.plugins.foodgo.android.library)
    alias(libs.plugins.foodgo.android.compose)
    alias(libs.plugins.koin.compiler)
}

android {
    namespace = "com.space.core.navigation"
}

dependencies {
    implementation(libs.bundles.koin)
}