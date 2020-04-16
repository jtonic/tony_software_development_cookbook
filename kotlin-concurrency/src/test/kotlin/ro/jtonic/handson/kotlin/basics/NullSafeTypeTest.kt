package ro.jtonic.handson.kotlin.basics

import io.kotest.matchers.shouldBe
import io.kotlintest.specs.StringSpec

class NullSafeTypeTest : StringSpec() {

  init {
    "test elvis operator" {
      var address: String? = null
      address ?: "unknown address" shouldBe "unknown address"

      address = "Kotlin Island"
      address shouldBe "Kotlin Island"
    }
  }
}
