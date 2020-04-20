package com.nstanciu.tutorials.mn.surveys.greeting

import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

@Client("/hello")
interface GreetingClient {

  @Get
  fun greet(): String
}