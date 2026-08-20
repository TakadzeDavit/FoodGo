import com.space.foodgo.extensions.implementationLibrary
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class FeatureDomainPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("foodgo.jvm.library")

            dependencies {
//                implementationModule(CORE_DOMAIN_MODULE)
                implementationLibrary("kotlinx-coroutines-core")
            }
        }
    }
}