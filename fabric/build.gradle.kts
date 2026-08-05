plugins {
    id("com.gradleup.shadow")
    id("dev.architectury.loom")
    id("architectury-plugin")
    id("matthiesen.shadow-platform-conventions")
}

architectury {
    platformSetupLoomIde()
    fabric()
}

val shadowBundle: Configuration by configurations.creating

dependencies {
    minecraft(libs.minecraft)
    mappings(loom.officialMojangMappings())

    compileOnly(libs.bundles.fabricCompileOnly)
    implementation(libs.bundles.fabricImplementation)
    modCompileOnly(libs.bundles.fabricModCompileOnly)
    modRuntimeOnly(libs.bundles.fabricModRuntimeOnly)
    modImplementation(libs.bundles.fabricModImplementation)
    modImplementation(libs.bundles.fabricModImplementationNoTransitive) { isTransitive = false }

    implementation(project(":common", configuration = "namedElements"))
    "developmentFabric"(project(":common", configuration = "namedElements"))
    shadowBundle(project(":common", configuration = "transformProductionFabric"))

    testImplementation(libs.junit.api)
    testRuntimeOnly(libs.junit.engine)
}

tasks {
    processResources {
        filesMatching("fabric.mod.json") {
            expand(project.properties)
        }
    }

    shadowJar {
        configurations = listOf(shadowBundle)
    }
}
