group = "ro.jtonic.handson"
version = appVersion

plugins {
  java
  kotlin("jvm") version kotlinVersion
}

subprojects {

  apply {
    plugin("java")
    plugin("org.jetbrains.kotlin.jvm")
  }

  dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.slf4j:slf4j-simple:$slf4jVersion")

    testImplementation("io.kotlintest:kotlintest-runner-junit5:$kotlinTestVersion")
    testImplementation("io.kotest:kotest-assertions-jvm:$kotestVersion")
  }

  tasks {
    compileKotlin {
      kotlinOptions.jvmTarget = javaVersion
    }
    compileTestKotlin {
      kotlinOptions.jvmTarget = javaVersion
    }

    test {
      useJUnitPlatform()
    }
  }
}
