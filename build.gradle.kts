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


    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        //useIR = true
        jvmTarget = "11"
        freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn", "-Xstring-concat=indy-with-constants")
//        freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn", "-Xstring-concat=indy")
//        freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn", "-Xstring-concat=inline")
    }
}

application {
    mainClass.set("MainKt")
}
