import com.space.foodgo.extensions.implementationBundle
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class FeatureDataPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("foodgo.android.library")
            pluginManager.apply("io.insert-koin.compiler.plugin")

            dependencies {
//                   implementationLibrary(CORE_DOMAIN_MODULE)
//                implementationModule(CORE_DATA_MODULE)
//                implementationModule(CORE_DOMAIN_MODULE)
                //  implementationModule(":feature:${featureName()}:domain")
                implementationBundle("koin")
            }
        }
    }
}