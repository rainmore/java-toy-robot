plugins {
    java
    application
    idea
}

group = "au.com.rainmore"
version = "1.0.0"
description = "Coding Assignment — Toy Robot"

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

application {
    mainClass.set(listOf(project.group.toString(), "Application").joinToString("."))
}

tasks.run.configure {
    standardInput = System.`in`
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:${project.properties["junit.version"]!!.toString()}"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.mockito:mockito-junit-jupiter:${project.properties["mockito-core.version"]!!.toString()}")
}

tasks.test {
    useJUnitPlatform()
}