package com.nstanciu.tutorials.mn.surveys.greeting

import io.micronaut.context.ApplicationContext
import io.micronaut.context.env.Environment

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

/*
  @JvmStatic
  fun main(args: Array<String>) {
    ApplicationContext.run().run {
      val client = createBean(RxHttpClient::class.java, "http://localhost:8080")
      val hello = client.toBlocking().retrieve(HttpRequest.GET<String>("/hello"), String::class.java)
      println(hello)
    }
  }
*/

  @JvmStatic
  fun main(args: Array<String>) {
    ApplicationContext.build(GreetingClientApp::class.java)
      .deduceEnvironment(false)
      .environments(Environment.CLI, Environment.TEST)
      .start().run {
//      val service = getBean(GreetingService::class.java)
//      service.printConf()

      val client = getBean(GreetingClient::class.java)
      val greet = client.greet()
      println(greet)
    }
  }
}
