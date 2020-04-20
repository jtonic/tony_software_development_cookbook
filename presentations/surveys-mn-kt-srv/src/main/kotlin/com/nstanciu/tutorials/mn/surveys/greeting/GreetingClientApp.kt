package com.nstanciu.tutorials.mn.surveys.greeting

import io.micronaut.context.ApplicationContext
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient

object GreetingClientApp {

/*
  @JvmStatic
  fun main(args: Array<String>) {
    ApplicationContext.run().run {
      val client = getBean(GreetingClient::class.java)
      val greet = client.greet()
      println(greet)
    }
  }
*/

  @JvmStatic
  fun main(args: Array<String>) {
    ApplicationContext.run().run {
      val client = createBean(RxHttpClient::class.java, "http://localhost:8080")
      val hello = client.toBlocking().retrieve(HttpRequest.GET<String>("/hello"), String::class.java)
      println(hello)
    }
  }
}
