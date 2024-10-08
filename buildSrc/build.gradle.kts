plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    gradlePluginPortal()
    maven("https://repo.mewcraft.cc/releases")
    maven("https://repo.mewcraft.cc/private") {
        credentials {
            username = providers.gradleProperty("nyaadanbou.mavenUsername").orNull
            password = providers.gradleProperty("nyaadanbou.mavenPassword").orNull
        }
    }
}

dependencies {
    implementation(local.plugin.shadow)
    implementation(local.plugin.nyaadanbou.conventions)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}