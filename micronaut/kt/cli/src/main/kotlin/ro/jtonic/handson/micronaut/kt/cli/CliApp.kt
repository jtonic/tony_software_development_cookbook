package ro.jtonic.handson.micronaut.kt.cli

import io.micronaut.context.BeanContext
import ro.jtonic.handson.micronaut.kt.cli.service.PersonService

object CliApp {

  @JvmStatic
  fun main(args: Array<String>) {
    BeanContext.run().run {
      val personService = getBean(PersonService::class.java)
      personService.findAll().forEach(::println)
    }
  }
}
