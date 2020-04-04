group = "ro.jtonic.handson.kt"
version = "1.0-SNAPSHOT"

plugins {
  kotlin("jvm") apply true
  kotlin("kapt") apply true
  kotlin("plugin.allopen") apply true
}

dependencies {

  implementation(kotlin("stdlib-jdk8"))
  implementation(kotlin("reflect"))

  kapt(platform("io.micronaut:micronaut-bom:$micronautVersion"))
  kapt("io.micronaut:micronaut-inject-java")
  kapt("io.micronaut:micronaut-validation")
  kapt("io.micronaut.configuration:micronaut-openapi")

  kaptTest(platform("io.micronaut:micronaut-bom:$micronautVersion"))
  kaptTest("io.micronaut:micronaut-inject-java")
}

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
}

application {
  mainClassName = "ro.jtonic.handson.micronaut.kt.web.App"
}

allOpen {
  annotation("io.micronaut.aop.Around")
}
