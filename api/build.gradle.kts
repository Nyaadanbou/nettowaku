plugins {
    id("nettowaku-conventions")
    `maven-publish`
}

version = "1.0.0"

dependencies {
    compileOnly(local.luckperms)
    compileOnly(local.checker.qual)
}

publishing {
    repositories {
        maven {
            name = "nyaadanbou"
            url = uri("https://repo.mewcraft.cc/private")
            credentials {
                username = providers.gradleProperty("nyaadanbou.mavenUsername").orNull
                password = providers.gradleProperty("nyaadanbou.mavenPassword").orNull
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}