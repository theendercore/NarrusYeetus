plugins {
    id("fabric-loom") version "1.11-SNAPSHOT"
}

group = project.properties["maven_group"]!!
version = project.properties["mod_version"]!!
base.archivesName.set(project.properties["archives_base_name"] as String)

repositories {
    mavenCentral()
}

dependencies {
    minecraft("com.mojang:minecraft:1.21.9")
    mappings(loom.officialMojangMappings())
    modImplementation("net.fabricmc:fabric-loader:0.14.10")
}

tasks {
    processResources {
        inputs.property("version", project.version)
        filteringCharset = "UTF-8"

        filesMatching("fabric.mod.json") {
            expand(mapOf("version" to project.version))
        }
    }
    val targetJavaVersion = 21
    withType<JavaCompile> {
        options.encoding = "UTF-8"
        options.release.set(targetJavaVersion)
    }

    java {
        toolchain.languageVersion.set(JavaLanguageVersion.of(JavaVersion.toVersion(targetJavaVersion).toString()))
        withSourcesJar()
    }
}