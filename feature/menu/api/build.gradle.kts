plugins {
    alias(libs.plugins.foodgo.android.library)
    alias(libs.plugins.foodgo.android.compose)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.space.foodgo.feature.menu.api"
}

dependencies {
    implementation(libs.kotlinx.serialization.json)
    implementation(projects.core.navigation)
}