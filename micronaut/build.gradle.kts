// https://guides.gradle.org/migrating-build-logic-from-groovy-to-kotlin/

group = "ro.jtonic.handson"
version = "1.0-SNAPSHOT"

plugins {
  java apply true
  kotlin("jvm") version kotlinVersion apply false
  kotlin("kapt") version kotlinVersion apply false
  kotlin("plugin.allopen") version kotlinVersion apply false
}

subprojects {

  apply {
    plugin("java")
  }

  repositories {
    mavenCentral()
  }

  dependencies {

    implementation(platform("io.micronaut:micronaut-bom:$micronautVersion"))
    implementation("io.micronaut:micronaut-runtime")
    implementation("io.micronaut:micronaut-http-server-netty")
    implementation("io.micronaut:micronaut-http-client")

    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonKtModuleVersion")
    runtimeOnly("ch.qos.logback:logback-classic:$logbackVersion")

    testImplementation(platform("org.junit:junit-bom:$junitVersion"))

    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("io.micronaut.test:micronaut-test-junit5")
    testImplementation("org.mockito:mockito-junit-jupiter:$mockitoVersion")
    testImplementation("org.assertj:assertj-core:$assertjVersion")
  }

  tasks {

    java {
      sourceCompatibility = JavaVersion.VERSION_1_8
    }
    test {
      useJUnitPlatform()
    }
  }
}
