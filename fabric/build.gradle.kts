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

    // Fix for Cobblemon dev on Fabric
    modRuntimeOnly("org.graalvm.js:js:22.3.0")
    modRuntimeOnly("org.graalvm.sdk:graal-sdk:22.3.0")
    modRuntimeOnly("org.graalvm.regex:regex:22.3.0")
    modRuntimeOnly("org.graalvm.truffle:truffle-api:22.3.0")
    modRuntimeOnly("com.ibm.icu:icu4j:71.1")

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
