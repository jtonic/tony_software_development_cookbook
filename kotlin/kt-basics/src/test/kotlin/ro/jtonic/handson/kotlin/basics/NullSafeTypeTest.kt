package ro.jtonic.handson.kotlin.basics

import io.kotest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class NullSafeTypeTest : StringSpec() {

  init {

    "test safe call operator" {
      data class User(val name: String, val address: String)

      var user: User? = null
      user?.address shouldBe null

      user = User("Tony", "Mihai Bravu")
      user?.address shouldBe "Mihai Bravu"
    }
  }
}
