package ro.jtonic.handson.kotlin.basics

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotlintest.specs.StringSpec

class NullSafeTypeTest : StringSpec() {

  init {

    "test safe call operator" {

      var user: User? = null
      user?.address shouldBe null

      user = User("Tony", "Mihai Bravu")
      user?.address shouldBe "Mihai Bravu"

    }

    "test elvis operator" {

      var address: String? = null
      address ?: "unknown address" shouldBe "unknown address"

      address = "Kotlin Island"
      address shouldBe "Kotlin Island"

    }






    "test safe cast operator" {

      val jtonic = User("jtonic", "Mihai Bravu") as Any
      val tony = Person("Tony", 18) as Any

      (jtonic as? User) shouldNotBe null
      (tony as? User) shouldBe null

      val jtonicUserAddress = (jtonic as? User)?.address
      val tonyUserAddress = (tony as? User)?.address

      jtonicUserAddress shouldBe "Mihai Bravu"
      tonyUserAddress shouldBe null

    }







  }
}
