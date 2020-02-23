plugins {
    kotlin("jvm") version kotlinVersion
    application
}

group = "ro.jtonic.handson"
version = appVersion

repositories {
    maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.slf4j:slf4j-simple:$slf4jVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutinesVersion")

    testImplementation("io.kotlintest:kotlintest-runner-junit5:$kotlinTestVersion")
}

application {
  mainClassName = "ro.jtonic.handson.kotlin.concurrency.App"
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

