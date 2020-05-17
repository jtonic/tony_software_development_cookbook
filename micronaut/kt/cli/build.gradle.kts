group = "ro.jtonic.handson.kt"
version = "1.0-SNAPSHOT"

plugins {
  application apply true
  kotlin("jvm") apply true
  kotlin("kapt") apply true
  kotlin("plugin.allopen") apply true
  id("com.github.johnrengelman.shadow") version shadowJarVersion
}

dependencies {

  implementation(kotlin("stdlib-jdk8"))
  implementation(kotlin("reflect"))

  implementation("info.picocli:picocli")
  implementation("io.micronaut.configuration:micronaut-picocli")

  kapt(platform("io.micronaut:micronaut-bom:$micronautVersion"))
  kapt("io.micronaut:micronaut-inject-java")
  kapt("io.micronaut.configuration:micronaut-picocli")

  kaptTest(platform("io.micronaut:micronaut-bom:$micronautVersion"))
  kaptTest("io.micronaut:micronaut-inject-java")
}

val mainClass: String =  "ro.jtonic.handson.micronaut.kt.cli.CliApp"

tasks {
  compileKotlin {
    kotlinOptions {
      jvmTarget = jvmVersion
      javaParameters = true
    }
  }
  compileTestKotlin {
    kotlinOptions {
      jvmTarget = jvmVersion
      javaParameters = true
    }
  }
  test {
    useJUnitPlatform()
  }
  jar {
    manifest {
      attributes["Main-Class"] = mainClass
    }
  }
  application {
    mainClassName = mainClass
  }
  allOpen {
    annotation("io.micronaut.aop.Around")
  }
}
