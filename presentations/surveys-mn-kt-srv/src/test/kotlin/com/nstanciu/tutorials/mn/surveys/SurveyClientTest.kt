package com.nstanciu.tutorials.mn.surveys

import com.nstanciu.tutorials.mn.surveys.model.Survey
import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.StringSpec
import io.micronaut.context.ApplicationContext
import io.micronaut.core.type.GenericArgument
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.RxHttpClient
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.annotation.MicronautTest

@MicronautTest
class SurveyClientTest(
        ctx: ApplicationContext,
        surveyClient: SurveyClient,
        surveyRepository: SurveyRepository
): StringSpec({

    "test RxHttpClient" {
        val embeddedServer: EmbeddedServer = ctx.getBean(EmbeddedServer::class.java)
        val client: RxHttpClient = embeddedServer.applicationContext.createBean(RxHttpClient::class.java, embeddedServer.url)

        // this doesn't work!!!!
        val response: HttpResponse<List<Survey>> = client.toBlocking().exchange(HttpRequest.GET<List<Survey>>("/surveys"), object : GenericArgument<List<Survey>>() {})

        response.status shouldBe HttpStatus.OK
    }

    "test with declarative client SurveyRepository" {
      val surveys = surveyClient.getSurveys()
      surveys.let {
        it shouldNotBe null
        it.size shouldBe 1
        it[0] shouldBe surveyRepository.getSurveys()[0]
      }
    }
})
