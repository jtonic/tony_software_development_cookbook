package ro.jtonic.handson.micronaut.kt.web
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/")
class GreetingController(private val greetingService: GreetingService) {

  @Get("/hello/{name}")
  fun hello(name: String) = greetingService.greet(name)
}
