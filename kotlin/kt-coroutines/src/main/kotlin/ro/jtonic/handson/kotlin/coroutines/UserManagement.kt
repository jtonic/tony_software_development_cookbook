package ro.jtonic.handson.kotlin.coroutines

import kotlinx.coroutines.delay
import java.util.concurrent.TimeUnit

object UserManagement {

  suspend fun getName(): String {
    println("getName current thread = ${Thread.currentThread()}")
    delay(TimeUnit.SECONDS.toMillis(2))
    return "Tony"
  }

  suspend fun getAge(): Int {
    println("getAge current thread = ${Thread.currentThread()}")
    delay(TimeUnit.SECONDS.toMillis(2))
    return 50
  }
}