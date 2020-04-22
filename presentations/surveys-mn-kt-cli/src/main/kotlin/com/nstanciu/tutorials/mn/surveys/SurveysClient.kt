package com.nstanciu.tutorials.mn.surveys

import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

//@Client(id = "\${greeting.client.url}", path = "\${greeting.client.path}")
//@Client("\${greeting.client.url}\${greeting.client.path}")
@Client("http://localhost:8080/surveys")
interface SurveysClient {

  @Get
  fun getAllSurveys(): String
}