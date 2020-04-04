package ro.jtonic.handson.micronaut

import io.micronaut.context.BeanContext
import ro.jtonic.handson.micronaut.server.service.PersonService

object CliApp {

  @JvmStatic
  fun main(args: Array<String>) {
    val ctx = BeanContext.run()
    val personService = ctx.getBean(PersonService::class.java)
    val allPersons = personService.findAll()

    allPersons.forEach(::println)
  }
}
