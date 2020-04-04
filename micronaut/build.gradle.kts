plugins {
  java
  application
  kotlin("jvm") version kotlinVersion
  kotlin("kapt") version kotlinVersion
  kotlin("plugin.allopen") version kotlinVersion
}

group = "ro.jtonic.handson"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {

  implementation(platform("io.micronaut:micronaut-bom:$micronautVersion"))

  implementation(kotlin("stdlib-jdk8"))
  implementation(kotlin("reflect"))
  implementation("io.micronaut:micronaut-runtime")
  implementation("io.micronaut:micronaut-http-server-netty")
  implementation("io.micronaut:micronaut-http-client")

  kapt(platform("io.micronaut:micronaut-bom:$micronautVersion"))
  kapt("io.micronaut:micronaut-inject-java")
  kapt("io.micronaut:micronaut-validation")
  kapt("io.micronaut.configuration:micronaut-openapi")

  runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonKtModuleVersion")
  runtimeOnly("ch.qos.logback:logback-classic:$logbackVersion")

  testImplementation(platform("org.junit:junit-bom:$junitVersion"))

  testImplementation("org.junit.jupiter:junit-jupiter")
  testImplementation("io.micronaut.test:micronaut-test-junit5")
  testImplementation("org.mockito:mockito-junit-jupiter:$mockitoVersion")

  kaptTest(platform("io.micronaut:micronaut-bom:$micronautVersion"))
  kaptTest("io.micronaut:micronaut-inject-java")
}

configure<JavaPluginConvention> {
  sourceCompatibility = JavaVersion.VERSION_1_8
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
  mainClassName = "ro.jtonic.handson.micronaut.App"
}

allOpen {

  annotation("io.micronaut.aop.Around")
}
