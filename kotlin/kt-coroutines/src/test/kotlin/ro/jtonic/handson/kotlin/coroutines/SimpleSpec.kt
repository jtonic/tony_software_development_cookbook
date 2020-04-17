package ro.jtonic.handson.kotlin.coroutines

import io.kotlintest.matchers.doubles.shouldBeGreaterThan
import io.kotlintest.matchers.doubles.shouldBeLessThan
import io.kotlintest.specs.StringSpec
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import ro.jtonic.handson.kotlin.coroutines.UserManagement.getAge
import ro.jtonic.handson.kotlin.coroutines.UserManagement.getName
import java.util.concurrent.TimeUnit.SECONDS
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

@ExperimentalTime
class SimpleSpec : StringSpec() {

  init {

    "coroutines are better tested with kotlintest" {
      val latency = measureTime {
        println("Thread.currentThread() = ${Thread.currentThread()}")
        delay(SECONDS.toMillis(1))
      }
      latency.inSeconds shouldBeGreaterThan 1L.toDouble()
    }

    "should take a bit more that 2 seconds to get user name and age" {
      println("Test execution thread = ${Thread.currentThread()}")
      val latency = measureTime {
        // --> async/await
        val name = async { getName() }
        val age = async { getAge() }
        val result = "Name: ${name.await()}, age: ${age.await()}"
        // ---
        println("result = $result")
      }

      val latencyInSecs = latency.inSeconds
      println("latencyInSecs = $latencyInSecs")
      latencyInSecs shouldBeLessThan 2.1
    }
  }
}

