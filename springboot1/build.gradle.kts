plugins {
  java
  application
}

group = "ro.jtonic.springboot1"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {

  implementation("org.springframework.boot:spring-boot-starter-web:$springBootVersion")

  testImplementation("org.springframework.boot:spring-boot-starter-test:$springBootVersion")
  testImplementation("junit:junit:$junitVersion")
}

configure<JavaPluginConvention> {
  sourceCompatibility = JavaVersion.VERSION_1_8
}

application {
  mainClassName = "ro.jtonic.handson.springboot1.MainApp"
}
