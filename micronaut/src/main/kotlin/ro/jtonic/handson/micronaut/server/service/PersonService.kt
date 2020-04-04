package ro.jtonic.handson.micronaut.server.service

import ro.jtonic.handson.micronaut.model.Person
import javax.inject.Singleton

@Singleton
class PersonService {

  fun findAll(): List<Person> =
    listOf(
      Person(1, "Antonel-Ernest Pazargic"),
      Person(2, "Magda Jipa")
    )
}
