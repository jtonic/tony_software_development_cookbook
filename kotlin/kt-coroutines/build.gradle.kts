plugins {
  application
}

dependencies {
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
}

application {
  mainClass.set("ro.jtonic.handson.kotlin.coroutines.App")
}
