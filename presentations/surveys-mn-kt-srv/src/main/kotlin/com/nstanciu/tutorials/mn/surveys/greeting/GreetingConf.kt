package com.nstanciu.tutorials.mn.surveys.greeting

import io.micronaut.context.annotation.ConfigurationProperties
import io.micronaut.context.annotation.Requires

@ConfigurationProperties(GreetingConf.PREFIX)
@Requires(property = GreetingConf.PREFIX)
class GreetingConf(
  var url: String = "http://locahost:8080/",
  var path: String = "/hello"
) {

  override fun toString(): String {
    return "GreetingConf(url='$url', path='$path')"
  }

  companion object {
    const val PREFIX = "greeting.client"
  }
}
