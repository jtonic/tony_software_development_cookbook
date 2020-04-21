package com.nstanciu.tutorials.mn.surveys.greeting

import io.micronaut.runtime.Micronaut

object GreetingServerApp {

  @JvmStatic
  fun main(vararg args: String) {

    Micronaut.build()
      .packages(GreetingServerApp::class.java.`package`.name)
      .mainClass(GreetingServerApp.javaClass)
      .mainClass(GreetingServerApp.javaClass)
      .start()
  }
}