import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.30"
    application
}

group = "com.dazare.study"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    // https://kotlinlang.org/docs/whatsnew14.html#minimum-gradle-version-for-kotlin-projects
    // https://kotlinlang.org/docs/gradle.html#dependency-on-the-standard-library
    //implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.6")
    // https://blog.jetbrains.com/kotlin/2020/02/improved-gradle-kts-ide-support/

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        //useIR = true
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-Xjvm-default=all-compatibility")
        //freeCompilerArgs = listOf("-Xjvm-default=all")
    }
}

application {
    mainClass.set("MainKt")
}
