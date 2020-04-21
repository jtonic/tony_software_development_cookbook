package com.nstanciu.tutorials.mn.surveys

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.micronaut.context.ApplicationContext
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.RxHttpClient
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.annotation.MicronautTest

@MicronautTest
class SurveysControllerTest(ctx: ApplicationContext): StringSpec({

    "test the server is running" {
        assert(ctx.getBean(EmbeddedServer::class.java).isRunning)
    }

    "SurveysController server" {
        val embeddedServer: EmbeddedServer = ctx.getBean(EmbeddedServer::class.java)
        val client: RxHttpClient = embeddedServer.applicationContext.createBean(RxHttpClient::class.java, embeddedServer.url)

        // "a request is made to getSurveys"
        val response = client.toBlocking().exchange(HttpRequest.GET<List<String>>("/surveys"), String::class.java)

        // "the response is successful"
        response.status shouldBe HttpStatus.OK
    }
})