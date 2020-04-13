package ro.jtonic.handson.micronaut.kt.cli

import io.micronaut.context.ApplicationContext
import ro.jtonic.handson.micronaut.kt.cli.service.PersonService

object CliApp {

  @JvmStatic
  fun main(args: Array<String>) {
      ApplicationContext.run().use {
      val personService = it.getBean(PersonService::class.java)
      personService.findAll().forEach(::println)
    }
  }
}
