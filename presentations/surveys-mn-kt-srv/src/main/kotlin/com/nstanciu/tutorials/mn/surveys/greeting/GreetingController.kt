package com.nstanciu.tutorials.mn.surveys.greeting

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/hello")
class GreetingController {

  @Get
  fun greet() = "Hello"
}