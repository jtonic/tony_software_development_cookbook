package ro.jtonic.handson.micronaut.server.service

import io.micronaut.test.annotation.MicronautTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class PersonServiceTest {

  @Inject
  private lateinit var personService: PersonService

  @Test
  @DisplayName("find all persons")
  fun findAll() {

    val persons = personService.findAll()

    assertThat(persons)
      .hasSize(2)
  }
}
