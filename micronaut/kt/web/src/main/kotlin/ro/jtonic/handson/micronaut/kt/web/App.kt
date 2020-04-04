package ro.jtonic.handson.micronaut.kt.web

import io.micronaut.runtime.Micronaut

object App {

  @JvmStatic
  fun main(args: Array<String>) {
    Micronaut.build(*args)
      .packages("ro.jtonic.handson.micronaut.kt.web")
      .deduceEnvironment(false)
      .mainClass(App.javaClass)
      .start()
  }
}
