plugins {
    id("dev.architectury.loom")
    id("architectury-plugin")
    id("matthiesen.minecraft-module-conventions")
}

architectury {
    common("neoforge", "fabric")
}

dependencies {
    // Minecraft and mappings
    minecraft(libs.minecraft)
    mappings(loom.officialMojangMappings())

    // Main dependencies
    compileOnly(libs.bundles.commonCompileOnly)
    implementation(libs.bundles.commonImplementation)
    modCompileOnly(libs.bundles.commonModCompileOnly)
    modImplementation(libs.bundles.commonModImplementation)
    modImplementation(libs.bundles.commonModImplementationNoTransitive) { isTransitive = false }

    // Test dependencies
    testImplementation(libs.junit.api)
    testRuntimeOnly(libs.junit.engine)
}

tasks {
    processResources {
        duplicatesStrategy = DuplicatesStrategy.INCLUDE
        inputs.property("mod_name", project.property("mod_name").toString())
        filesMatching("pack.mcmeta") {
            expand(project.properties)
        }
    }
}
