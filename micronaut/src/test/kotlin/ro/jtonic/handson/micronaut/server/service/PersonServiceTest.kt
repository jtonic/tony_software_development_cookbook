package ro.jtonic.handson.micronaut.server.service

import io.micronaut.context.BeanContext
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PersonServiceTest {

  @Test
  @DisplayName("find all persons")
  fun findAll() {
    val personService = ctx.getBean(PersonService::class.java)
    val persons = personService.findAll()

    assertThat(persons)
      .hasSize(2)
  }

  companion object {

    private lateinit var ctx: BeanContext

    @BeforeAll
    @JvmStatic
    fun beforeAll() {
      ctx = BeanContext.run()
    }
  }
}
