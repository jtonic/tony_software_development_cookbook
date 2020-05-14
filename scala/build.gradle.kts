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
  implementation("org.scala-lang:scala-library:${Versions.scala}.1")

  testImplementation("org.scalatest:scalatest_${Versions.scala}:${Versions.scalaTest}")
  testImplementation("org.junit.platform:junit-platform-engine:${Versions.junit}")
  testImplementation("org.junit.platform:junit-platform-launcher:${Versions.junit}")
  testImplementation("co.helmethair:scalatest-junit-runner:${Versions.scalaTestJunitRunner}")
}

sourceSets {

  main {
    withConvention(ScalaSourceSet::class) {
      scala {
        setSrcDirs(listOf("src/main/scala", "src/main/java"))
      }
    }
    java {
      setSrcDirs(emptyList<String>())
    }
  }
  test {
    withConvention(ScalaSourceSet::class) {
      scala {
        setSrcDirs(listOf("src/test/scala", "src/test/java"))
      }
    }
    java {
      setSrcDirs(emptyList<String>())
    }
  }
}

configure<JavaPluginConvention> {
  sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks {

  withType<ScalaCompile>().configureEach {
    scalaCompileOptions.forkOptions.apply {
      memoryMaximumSize = "1g"
      jvmArgs = listOf("-XX:MaxPermSize=512m")
    }
  }
  test {
    useJUnitPlatform {
      includeEngines("scalatest")
    }
  }
}
