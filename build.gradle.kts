plugins {
    kotlin("jvm") version "2.0.20"
}

group = "com.blackchain"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_19
    targetCompatibility = JavaVersion.VERSION_19
}
repositories {
    mavenCentral()
}

dependencies {
    val http4kVersion = "5.6.4.0"
    implementation("org.http4k:http4k-client-okhttp:${http4kVersion}")
    implementation("org.http4k:http4k-core:${http4kVersion}")
    implementation("org.http4k:http4k-contract:${http4kVersion}")
    implementation("org.http4k:http4k-format-jackson:${http4kVersion}")
    implementation("org.http4k:http4k-server-jetty:${http4kVersion}")
    implementation(platform("org.http4k:http4k-bom:${http4kVersion}"))
    implementation("org.http4k:http4k-multipart:4.12.0")

    testImplementation(kotlin("test"))
}


tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(19)
}