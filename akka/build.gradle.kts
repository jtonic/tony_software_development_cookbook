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
  implementation("com.typesafe.akka:akka-actor_${Versions.scala}:${Versions.akka}")
  implementation("ch.qos.logback:logback-classic:${Versions.logback}")

  testImplementation("junit:junit:${Versions.junit}")
}

configure<JavaPluginConvention> {
  sourceCompatibility = JavaVersion.VERSION_1_8
}

application {
  mainClassName = "ro.jtonic.handson.akka.ActorSystemApp"
}
