package ro.jtonic.handson.kotlin.concurrency

import io.kotlintest.matchers.doubles.shouldBeGreaterThan
import io.kotlintest.matchers.string.shouldHaveLength
import io.kotlintest.specs.StringSpec
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.time.DurationUnit.SECONDS
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

@ExperimentalTime
class SimpleSpec : StringSpec({

    "suspendable computation runs sequentially by default" {
      val latency = measureTime {
        // runBlocking executes code inside the block sequentialy in the current thread
        runBlocking {
          println("Thread.currentThread() = ${Thread.currentThread()}")
          delay(SECONDS.toMillis(2))
          "hello" shouldHaveLength 5
        }
      }
      latency.inSeconds shouldBeGreaterThan 2L.toDouble()
    }
})
