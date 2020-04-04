package ro.jtonic.handson.micronaut.server

import javax.inject.Singleton

@Singleton
class GreetingService {

  fun greet(name: String) =
    "Hello $name"
}
