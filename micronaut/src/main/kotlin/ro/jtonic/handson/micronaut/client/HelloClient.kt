package ro.jtonic.handson.micronaut.client

import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

@Client("/")
interface HelloClient {

  @Get("/hello/{name}")
  fun hello(name: String): String
}
