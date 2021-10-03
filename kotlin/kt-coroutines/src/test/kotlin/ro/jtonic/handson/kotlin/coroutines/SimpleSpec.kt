package ro.jtonic.handson.kotlin.coroutines

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.comparables.shouldBeLessThan
import io.kotest.matchers.longs.shouldBeGreaterThanOrEqual
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

    "coroutines are better tested with kotest" {
      val latency = measureTime {
        println("Thread.currentThread() = ${Thread.currentThread()}")
        delay(SECONDS.toMillis(1))
      }
      latency.inWholeSeconds shouldBeGreaterThanOrEqual 1L
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

      val latencyInSecs = latency.inWholeSeconds.toDouble()
      println("latencyInSecs = $latencyInSecs")
      latencyInSecs shouldBeLessThan 2.1
    }
  }
}

