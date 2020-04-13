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

  fun Project.getDevelopmentOnlyConfiguration(): Configuration {
    return configurations.findByName("developmentOnly") ?: configurations.create("developmentOnly") {
      dependencies.add(project.dependencies.implementation("io.micronaut:micronaut-runtime-osx"))
      dependencies.add(project.dependencies.implementation("net.java.dev.jna:jna"))
      dependencies.add(project.dependencies.implementation("io.micronaut:micronaut-http-client"))
    }
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

    withType<JavaExec> {
      classpath = getDevelopmentOnlyConfiguration()

      val jvmArgsList = mutableSetOf("-noverify") as LinkedHashSet
      jvmArgsList += listOf("-XX:TieredStopAtLevel=1", "-Dcom.sun.management.jmxremote")
      jvmArgs = jvmArgsList.toList()
    }

    withType<JavaCompile> {
      with(options) {
        encoding = "UTF-8"
        compilerArgs.add("-parameters")
      }
    }

    java {
      sourceCompatibility = JavaVersion.VERSION_1_8
    }

    test {
      // the error `Could not find io.micronaut:micronaut-runtime-osx:.` occurs when uncomment the following
      // classpath = getDevelopmentOnlyConfiguration()
      useJUnitPlatform()
    }
  }
}
