plugins {
    kotlin("jvm") version "1.8.0"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val retrofitVersion: String by project
val gsonConverterVersion: String by project
val jacksonVersion: String by project
val loggingInterceptorVersion: String by project
val log4jVersion: String by project
val seleniumVersion: String by project
val webDriverManagerVersion: String by project
val junitVersion: String by project

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("com.squareup.retrofit2:retrofit:${retrofitVersion}")
    implementation("com.squareup.retrofit2:converter-gson:${gsonConverterVersion}")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:${jacksonVersion}")
    implementation("com.squareup.okhttp3:logging-interceptor:${loggingInterceptorVersion}")
    implementation("log4j:log4j:${log4jVersion}")
    implementation("org.seleniumhq.selenium:selenium-java:${seleniumVersion}")
    implementation("io.github.bonigarcia:webdrivermanager:${webDriverManagerVersion}")
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:${junitVersion}")
    testImplementation("org.junit.jupiter:junit-jupiter-params:${junitVersion}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${junitVersion}")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}