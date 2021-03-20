import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "ro.jtonic.handson"
version = appVersion

plugins {
  java
  kotlin("jvm") version kotlinVersion
  kotlin("plugin.spring") version kotlinVersion
  kotlin("kapt") version kotlinVersion
}

allprojects {

  apply {
    plugin("java")
    plugin("org.jetbrains.kotlin.jvm")
  }

  repositories {
    jcenter()
    maven(url = "http://packages.confluent.io/maven/")
  }

  dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("org.jetbrains.kotlin:kotlin-script-runtime:$kotlinVersion")
    implementation("org.slf4j:slf4j-simple:$slf4jVersion")

    testImplementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion")
  }

  tasks {
    withType<KotlinCompile> {
      kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict", "-Xinline-classes")
        jvmTarget = javaVersion
      }
    }
    withType<Test> {
      useJUnitPlatform()
    }
  }
}
