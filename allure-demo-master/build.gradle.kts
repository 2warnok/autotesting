plugins {
    java
    id("io.qameta.allure") version "2.9.4"
}

group = "io.eroshenkoam"
version = version

allure {
    report {
        version.set("2.18.1")
    }
    adapter {
        autoconfigure.set(true)
        aspectjWeaver.set(true)
        frameworks {
            junit5 {
                adapterVersion.set("2.18.1")
            }
        }
    }
}

tasks.withType(JavaCompile::class) {
    sourceCompatibility = "${JavaVersion.VERSION_1_8}"
    targetCompatibility = "${JavaVersion.VERSION_1_8}"
    options.encoding = "UTF-8"
}

tasks.withType(Test::class) {
    ignoreFailures = true
    useJUnitPlatform {

    }
    systemProperty("junit.jupiter.execution.parallel.enabled", "true")
    systemProperty("junit.jupiter.execution.parallel.config.strategy", "dynamic")

    systemProperty("junit.jupiter.extensions.autodetection.enabled", "true")
}


repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("commons-io:commons-io:2.11.0")
    implementation("io.qameta.allure:allure-java-commons:2.21.0")
    implementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    implementation("org.junit.jupiter:junit-jupiter-engine:5.9.2")
    implementation("org.junit.jupiter:junit-jupiter-params:5.9.2")
    implementation("junit:junit:4.13.2")
    implementation("io.appium:java-client:7.5.1")
    implementation ("org.slf4j:slf4j-api:2.0.6")
   // implementation ("org.testng:testng:7.7.0")
    implementation ("io.qameta.allure:allure-junit4:2.21.0")
}
