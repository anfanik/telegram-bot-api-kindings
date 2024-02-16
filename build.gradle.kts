plugins {
    kotlin("jvm") version "1.9.21"

    id("maven-publish")
}

group = "me.anfanik"
version = "7.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.github.pengrad:java-telegram-bot-api:7.0.1")
}

kotlin {
    jvmToolchain(8)
}

publishing {
    repositories {
        maven("https://repository.anfanik.me/public") {
            credentials {
                username = System.getenv("A5K_USERNAME")
                password = System.getenv("A5K_PASSWORD")
            }
        }
    }

    publications {
        create<MavenPublication>("maven") {
            artifact(tasks.jar)
        }
    }
}