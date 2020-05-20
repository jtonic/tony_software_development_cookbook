package ro.jtonic.handson.handsonsb23.resource

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hello")
class GreetingResource {

  @GetMapping
  fun hello(): String =
    "Hello from SpringBoot 2.3"
}