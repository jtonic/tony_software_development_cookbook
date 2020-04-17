plugins {
  application
}

dependencies {
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutinesVersion")
}

application {
  mainClassName = "ro.jtonic.handson.kotlin.coroutines.App"
}
