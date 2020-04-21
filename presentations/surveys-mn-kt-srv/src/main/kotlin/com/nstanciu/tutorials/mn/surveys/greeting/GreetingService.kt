package com.nstanciu.tutorials.mn.surveys.greeting

import io.micronaut.context.annotation.Value
import javax.inject.Singleton

@Singleton
class GreetingService(
  /*private val greetingConf: GreetingConf*/
  @Value("\${greeting.client.url}") val url: String,
  @Value("\${greeting.client.path}") val path: String
) {

  fun printConf() {
    println("url: $url, path: $path")
    // println(greetingConf)
  }
}
