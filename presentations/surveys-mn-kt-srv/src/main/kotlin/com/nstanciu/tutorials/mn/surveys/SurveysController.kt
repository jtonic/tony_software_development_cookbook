package com.nstanciu.tutorials.mn.surveys

import com.nstanciu.tutorials.mn.surveys.model.Survey
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import javax.inject.Inject

@Controller("/surveys")
class SurveysController {

  @Inject
  private lateinit var surveyRepository: SurveyRepository

  @Get
  fun getSurveys(): List<Survey> {
    return surveyRepository.getSurveys()
  }
}
