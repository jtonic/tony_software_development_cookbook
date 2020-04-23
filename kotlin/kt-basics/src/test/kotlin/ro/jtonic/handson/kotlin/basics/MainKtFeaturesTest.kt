package ro.jtonic.handson.kotlin.basics

import io.kotest.matchers.shouldBe
import io.kotlintest.matchers.string.shouldContain
import io.kotlintest.specs.StringSpec
import org.intellij.lang.annotations.Language

class MainKtFeaturesTest : StringSpec() {

  init {

    "test pattern matching with when (1)" {

        val no = 7

        val day: String = when(no) {
          6, 7 -> "weekend"
          else -> "week day"
        }

      day shouldBe "weekend"
    }

    "test pattern matching with when (2)" {

      val person = Person("Tony", 18) as Any

      val personInfo: String = when(person) {
        is String -> person
        is Person -> person.name  //smart cast
        else -> person.toString()
      }
      personInfo shouldBe "Tony"
    }

    "test smart cast" {

      val person = Person("Tony", 18) as Any

      val personInfo = if(person is Person) {
        person.name
      } else {
        person.toString()
      }

      personInfo shouldBe "Tony"
    }

    "test expression is almost everywhere (try/catch)" {

      val age = try {
        Integer.parseInt("tony's age")
      } catch (e: Exception) {
        90
      }

      age shouldBe 90
    }

    "test extension property" {

      val tony = Employee("Antonel", "Pazargic", 18)

      tony.fullName shouldBe "Antonel Pazargic"
    }

    "test multiline string interpolation, named and default parameter" {

      @Language("json")
      fun toJson(firstName: String, lastName: String, age: Int = 18) = """
        {
          "firstName": "$firstName",
          "lastName": "$lastName",
          "age": $age
        }
      """.trimIndent()

      toJson(firstName = "Antonel", lastName = "Pazargic") shouldContain """"age": 18"""
    }
  }
}

val Employee.fullName: String
  get() =
    "${this.firstName} ${this.lastName}"

