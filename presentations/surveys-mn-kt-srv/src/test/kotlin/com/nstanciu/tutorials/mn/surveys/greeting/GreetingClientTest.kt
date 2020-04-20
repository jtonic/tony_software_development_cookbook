package com.nstanciu.tutorials.mn.surveys.greeting

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.micronaut.context.ApplicationContext
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.RxHttpClient
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.annotation.MicronautTest

@MicronautTest(application = GreetingServerApp::class)
class GreetingClientTest(
  private val ctx: ApplicationContext,
  private val greetingClient: GreetingClient
) : StringSpec({

  "test greeting client" {
    val greet = greetingClient.greet()
    greet shouldBe "Hello"
  }

  "test rxHttpClient" {
    val server = ctx.getBean(EmbeddedServer::class.java)
    val rxHttpClient = ctx.createBean(RxHttpClient::class.java, server.url)
    val response: HttpResponse<String> = rxHttpClient.toBlocking().exchange(HttpRequest.GET<String>("/hello"), String::class.java)

    response.status shouldBe HttpStatus.OK
    response.body.isPresent shouldBe true
    response.body.get() shouldBe "Hello"
  }
})