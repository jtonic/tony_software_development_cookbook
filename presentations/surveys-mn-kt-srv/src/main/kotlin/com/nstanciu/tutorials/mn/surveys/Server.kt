package com.nstanciu.tutorials.mn.surveys

import io.micronaut.runtime.Micronaut

object Server {

  @JvmStatic
  fun main(args: Array<String>) {

    Micronaut.build()
      .packages("com.nstanciu.tutorials.mn.surveys")
      .mainClass(Server.javaClass)
      .start()
  }
}