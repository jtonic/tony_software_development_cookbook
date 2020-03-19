plugins {
  java
  application
}

group = "ro.jtonic.handson"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  implementation("com.typesafe.akka:akka-actor_$scalaVersion:$akkaVersion")
//  implementation("org.slf4j:slf4j-simple:$slf4jVersion")
  implementation("ch.qos.logback:logback-classic:$logbackVersion")

  testImplementation("junit:junit:$junitVersion")
}

configure<JavaPluginConvention> {
  sourceCompatibility = JavaVersion.VERSION_1_8
}

application {

  mainClassName = "ro.jtonic.handson.akka.SimpleActorApp"
}