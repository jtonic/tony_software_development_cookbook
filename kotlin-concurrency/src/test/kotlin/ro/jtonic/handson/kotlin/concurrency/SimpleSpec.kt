package ro.jtonic.handson.kotlin.concurrency

import io.kotlintest.matchers.string.shouldHaveLength
import io.kotlintest.specs.StringSpec

class SimpleSpec : StringSpec() {

  init {
    "hello word should have 5 characters" {
      "Hello" shouldHaveLength 5
    }
  }
}
