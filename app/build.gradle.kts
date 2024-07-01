
/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java application project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.8/userguide/building_java_projects.html in the Gradle documentation.
 */
plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
    id("io.freefair.lombok") version "8.6"
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()

}

dependencies {
    // Use JUnit test framework.
    testImplementation(libs.junit)

    // This dependency is used by the application.
    implementation(libs.guava)
// https://mvnrepository.com/artifact/org.json/json
    implementation("org.json:json:20240303")



}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(20)
    }
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "org.example.App"
    }
}

application {
    // Define the main class for the application.
    mainClass = "org.example.App"
}
