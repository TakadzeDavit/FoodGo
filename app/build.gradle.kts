plugins {
    alias(libs.plugins.foodgo.android.application)
    alias(libs.plugins.foodgo.android.compose)
    alias(libs.plugins.koin.compiler)
}

android {
    namespace = "com.space.foodgo"

    defaultConfig {
        applicationId = "com.space.foodgo"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
}

dependencies {
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.bundles.koin)

    // modules
    implementation(projects.core.navigation)
    implementation(projects.core.ui)
    implementation(projects.core.presentation)
    implementation(projects.core.data)
    implementation(projects.core.domain)

    implementation(projects.feature.menu.presentation)
    implementation(projects.feature.menu.api)

    implementation(projects.feature.cart.presentation)
    implementation(projects.feature.cart.api)
}