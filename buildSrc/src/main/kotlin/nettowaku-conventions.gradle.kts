plugins {
    id("nyaadanbou-conventions.repositories")
    id("com.gradleup.shadow")
    `java-library`
}

group = "cc.mewcraft.nettowaku"

repositories {
    mavenCentral()
    maven("https://repo.mewcraft.cc/releases")
    maven("https://repo.mewcraft.cc/private") {
        credentials {
            username = providers.gradleProperty("nyaadanbou.mavenUsername").orNull
            password = providers.gradleProperty("nyaadanbou.mavenPassword").orNull
        }
    }
}

java {
    withSourcesJar()

    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}
