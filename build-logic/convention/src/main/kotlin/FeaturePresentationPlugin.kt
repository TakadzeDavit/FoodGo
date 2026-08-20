import com.space.foodgo.extensions.CORE_DOMAIN_MODULE
import com.space.foodgo.extensions.CORE_NAVIGATION_MODULE
import com.space.foodgo.extensions.CORE_PRESENTATION_MODULE
import com.space.foodgo.extensions.CORE_UI_MODULE
import com.space.foodgo.extensions.featureName
import com.space.foodgo.extensions.implementationBundle
import com.space.foodgo.extensions.implementationLibrary
import com.space.foodgo.extensions.implementationModule
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class FeaturePresentationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("foodgo.android.library")
            pluginManager.apply("foodgo.android.compose")
            pluginManager.apply("io.insert-koin.compiler.plugin")

            dependencies {
                implementationModule(CORE_DOMAIN_MODULE)
                implementationModule(CORE_UI_MODULE)
                implementationModule(CORE_NAVIGATION_MODULE)
                implementationModule(CORE_PRESENTATION_MODULE)
                implementationBundle("koin")
                implementationModule(":feature:${featureName()}:api")
                implementationLibrary("androidx-lifecycle-viewmodel-ktx")
                implementationLibrary("androidx-lifecycle-viewmodel-compose")
                implementationLibrary("kotlinx-serialization-json")
            }
        }
    }
}