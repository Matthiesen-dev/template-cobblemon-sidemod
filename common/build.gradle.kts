plugins {
    id("dev.architectury.loom")
    id("architectury-plugin")
    id("matthiesen.minecraft-module-conventions")
}

architectury {
    common("neoforge", "fabric")
}

dependencies {
    minecraft(libs.minecraft)
    mappings(loom.officialMojangMappings())

    compileOnly(libs.bundles.commonCompileOnly)
    implementation(libs.bundles.commonImplementation)
    modCompileOnly(libs.bundles.commonModCompileOnly)
    modImplementation(libs.bundles.commonModImplementation)
    modImplementation(libs.bundles.commonModImplementationNoTransitive) { isTransitive = false }

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
