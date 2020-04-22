package com.nstanciu.tutorials.mn.surveys

import com.nstanciu.tutorials.mn.surveys.model.Survey
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

@Client(id = "\${surveys.client.url}", path = "/surveys")
interface SurveysClient {

  @Get
  fun getAllSurveys(): List<Survey>
}