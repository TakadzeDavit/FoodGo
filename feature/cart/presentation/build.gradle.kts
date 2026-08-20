plugins {
    alias(libs.plugins.foodgo.android.feature.presentation )
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.space.foodgo.feature.cart.presentation"
}

dependencies {
    implementation(projects.feature.menu.api)
}