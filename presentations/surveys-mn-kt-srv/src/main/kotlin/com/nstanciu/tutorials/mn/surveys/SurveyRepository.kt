package com.nstanciu.tutorials.mn.surveys

import com.nstanciu.tutorials.mn.surveys.model.Survey
import java.util.UUID
import javax.inject.Singleton

@Singleton
class SurveyRepository {

  private val surveysData: List<Survey> by lazy {
    listOf(Survey(UUID.randomUUID(), "Micronaut http client", "Micronaut http client", "Micronaut"))
  }

  fun getSurveys(): List<Survey> = this.surveysData
}