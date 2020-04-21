package com.nstanciu.tutorials.mn.surveys.greeting

import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

@Client("http://localhost:8080")
//@Client(id = "\${greeting.client.url}", path = "\${greeting.client.path}")
interface GreetingClient {

  @Get("/hello")
  fun greet(): String
}