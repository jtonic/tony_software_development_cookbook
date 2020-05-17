plugins {
  java
  scala
  application
}

group = "ro.jtonic.handson"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.scala-lang:scala-library:2.13.1")
  implementation("com.twitter:finagle-http_2.13:20.4.1")

  testImplementation("org.scalatest:scalatest_2.13:3.1.1")
}

configure<JavaPluginConvention> {
  sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<ScalaCompile>().configureEach {
  scalaCompileOptions.forkOptions.apply {
    memoryMaximumSize = "1g"
    jvmArgs = listOf("-XX:MaxPermSize=512m")
  }
}

application {
  mainClassName = "ro.jtonic.handson.scala.finagle.MainApp"
}
