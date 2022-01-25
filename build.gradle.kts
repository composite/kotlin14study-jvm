import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    kotlin("jvm") version "1.5.0"
    application
}

group = "com.dazare.study"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {

    // https://codechacha.com/ko/unittest-with-kotlintest-in-kotlin/
    testImplementation("io.kotlintest:kotlintest-runner-junit5:3.4.2")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "11"
    }
}

application {
    mainClass.set("MainKt")
}
