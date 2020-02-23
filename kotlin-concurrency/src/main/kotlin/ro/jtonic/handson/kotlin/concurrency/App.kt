package ro.jtonic.handson.kotlin.concurrency

import kotlinx.coroutines.runBlocking

object App {

  @JvmStatic
  fun main(vararg args: String) = runBlocking {
    println("Current thread: ${Thread.currentThread()}")
    println("Hello kotlin coroutines!!!")
  }
}

