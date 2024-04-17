plugins {
    java
    `maven-publish`
    id("neko.repositories") version "1.0"
}

group = "cc.mewcraft"
version = "1.0.0"

dependencies {
    compileOnly(libs.luckperms)
    compileOnly(libs.checker.qual)
}

publishing {
    repositories {
        maven {
            name = "mewcraftRepository"
            url = uri("https://repo.mewcraft.cc/private")
            credentials(PasswordCredentials::class)
            authentication {
                create<BasicAuthentication>("basic")
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}