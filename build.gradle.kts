import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val assertJVersion = "3.11.1"
val jupiterVersion = "5.3.2"

plugins {
    kotlin("jvm") version "1.3.11"
}

group = "com.github.nwillc"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:$jupiterVersion")
    testImplementation("org.assertj:assertj-core:$assertJVersion")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:$jupiterVersion")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    withType<Test> {
        useJUnitPlatform()
        testLogging.showStandardStreams = true
    }
}