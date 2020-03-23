plugins {
  java
  application
  id("org.springframework.boot") version springBootVersion
}

group = "ro.jtonic.springboot1"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {

  implementation("org.springframework.boot:spring-boot-starter-web:$springBootVersion")
  implementation("com.typesafe.akka:akka-actor_$scalaVersion:$akkaVersion")
  implementation("ch.qos.logback:logback-classic:$logbackVersion")

  compileOnly("org.projectlombok:lombok:$lombokVersion")
  annotationProcessor("org.projectlombok:lombok:$lombokVersion")

  testImplementation("org.springframework.boot:spring-boot-starter-test:$springBootVersion")
  testImplementation("junit:junit:$junitVersion")
  testAnnotationProcessor("org.projectlombok:lombok:$lombokVersion")
}

java {
  sourceCompatibility = JavaVersion.VERSION_1_8
  targetCompatibility = JavaVersion.VERSION_1_8
}

configure<JavaPluginConvention> {
  sourceCompatibility = JavaVersion.VERSION_1_8
}

application {
  mainClassName = "ro.jtonic.handson.springboot1.MainApp"
}
