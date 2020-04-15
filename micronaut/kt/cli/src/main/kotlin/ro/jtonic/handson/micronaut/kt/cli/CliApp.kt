package ro.jtonic.handson.micronaut.kt.cli

import io.micronaut.context.BeanContext
import ro.jtonic.handson.micronaut.kt.cli.service.IngPersonalInfo
import ro.jtonic.handson.micronaut.kt.cli.service.PersonService

object CliApp {

  @JvmStatic
  fun main(args: Array<String>) {
    BeanContext.run().run {
      val personService = getBean(PersonService::class.java)
      personService.findAll().forEach(::println)

      val ingPersonalInfo = getBean(IngPersonalInfo::class.java)
      val employee = ingPersonalInfo.getInfo("Antonel-Ernest Pazargic")
      println("employee = $employee")
    }
  }
}
