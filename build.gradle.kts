plugins {
    kotlin("jvm") version "1.6.10"
}

group = "com.codersee"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-jackson:2.9.0")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}