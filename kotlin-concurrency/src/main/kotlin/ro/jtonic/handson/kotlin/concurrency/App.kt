package ro.jtonic.handson.kotlin.concurrency

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import ro.jtonic.handson.kotlin.concurrency.UserManagement.getAge
import ro.jtonic.handson.kotlin.concurrency.UserManagement.getName
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

object App {

  @ExperimentalTime
  @JvmStatic
  fun main(vararg args: String) = runBlocking {

    println("Main app current thread = ${Thread.currentThread()}")
    val latency = measureTime {
      // --> async/await
      val name = async { getName() }
      val age = async { getAge() }
      val personInfo = "${name.await()}, ${age.await()}"
      // ---
      println("personInfo = $personInfo")
    }
    assert(latency.inSeconds < 2.1) {
      "The latency of getting the person information should be a bit longer than 2 sec"
    }
    println("latency = $latency")
  }
}

