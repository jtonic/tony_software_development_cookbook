plugins {
  application
}

dependencies {
  implementation(rootProject.deps.kotlinCoroutines)
}

application {
  mainClass.set("ro.jtonic.handson.kotlin.coroutines.App")
}
