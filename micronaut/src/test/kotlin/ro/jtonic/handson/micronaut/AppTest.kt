package ro.jtonic.handson.micronaut

import io.micronaut.test.annotation.MicronautTest
import org.junit.jupiter.api.Test
import ro.jtonic.handson.micronaut.client.HelloClient
import javax.inject.Inject

@MicronautTest
class AppTest {

  @Inject
  lateinit var helloClient: HelloClient

  @Test
  fun testHello() {
    val greet = helloClient.hello("jtonic")
    println("body = $greet")
  }
}
