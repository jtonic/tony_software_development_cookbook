package ro.jtonic.handson.micronaut.kt.web
import javax.inject.Singleton

@Singleton
class GreetingService {

  fun greet(name: String) =
    "Hello $name"
}
