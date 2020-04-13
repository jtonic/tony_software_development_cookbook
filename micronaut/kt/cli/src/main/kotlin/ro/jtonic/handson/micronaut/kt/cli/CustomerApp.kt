package ro.jtonic.handson.micronaut.kt.cli

import io.micronaut.context.ApplicationContext
import ro.jtonic.handson.micronaut.kt.cli.service.CustomerService

object CustomerApp {

  @JvmStatic
  fun main(args: Array<String>) {
      ApplicationContext.run().use {
      val customerService = it.getBean(CustomerService::class.java)
      println(customerService.getInfo())
    }
  }
}
