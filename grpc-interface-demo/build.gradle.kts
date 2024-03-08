import org.gradle.kotlin.dsl.*
import com.google.protobuf.gradle.*

plugins {
    `maven-publish`
    `java-library`
    id("com.google.protobuf") version "0.8.18"
    kotlin("jvm") version "1.8.22"
    id("idea")
}

group = "ai.sendy.victor.grpc"
version = "1.0.0"

val protobufVersion = "3.23.4"
val grpcVersion = "1.58.0"

repositories {
    mavenCentral()
}

dependencies {

    implementation("io.grpc:grpc-protobuf:$grpcVersion")
    implementation("io.grpc:grpc-stub:$grpcVersion")
    compileOnly("jakarta.annotation:jakarta.annotation-api:1.3.5") // Java 9+ compatibility - Do NOT update to 2.0.0

    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}


kotlin {
    jvmToolchain(17)
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:$protobufVersion"
    }
    generatedFilesBaseDir = "$projectDir/src/generated"
    tasks.named<Delete>("clean") {
        delete(generatedFilesBaseDir)
    }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:$grpcVersion"
        }
    }
    generateProtoTasks {
        all().configureEach {
            plugins {
                id("grpc")
            }
        }
    }
}

idea {
    module {
        sourceDirs.add(file("src/generated/main/java"))
        sourceDirs.add(file("src/generated/main/grpc"))
        generatedSourceDirs.add(file("src/generated/main/java"))
        generatedSourceDirs.add(file("src/generated/main/grpc"))
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "ai.sendy.victor.grpc"
            artifactId = "grpc-interface-demo"
            version = "1.0.0"
            from(components["java"])
        }
    }
}

