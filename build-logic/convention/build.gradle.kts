import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
}

group = "com.space.foodgo.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.compose.compiler.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidLibrary") {
            id = "foodgo.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidApplication") {
            id = "foodgo.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidCompose") {
            id = "foodgo.android.compose"
            implementationClass = "AndroidComposeConventionPlugin"
        }
        register("featurePresentation") {
            id = "foodgo.android.feature.presentation"
            implementationClass = "FeaturePresentationPlugin"
        }
        register("featureData") {
            id = "foodgo.android.feature.data"
            implementationClass = "FeatureDataPlugin"
        }
        register("featureDomain") {
            id = "foodgo.feature.domain"
            implementationClass = "FeatureDomainPlugin"
        }
        register("jvmLibrary") {
            id = "foodgo.jvm.library"
            implementationClass = "JvmLibraryConventionPlugin"
        }
    }
}