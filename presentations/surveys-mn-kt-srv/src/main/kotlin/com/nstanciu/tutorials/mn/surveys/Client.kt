package com.nstanciu.tutorials.mn.surveys

import com.nstanciu.tutorials.mn.surveys.model.Survey
import io.micronaut.context.ApplicationContext

object Client {

  @JvmStatic
  fun main(args: Array<String>) {
    ApplicationContext.run().use {
      val surveyClient = it.getBean(SurveyClient::class.java)
      val surveys = surveyClient.getSurveys()
      val firstSurvey: Survey = surveys[0]
      println("firstSurvey = $firstSurvey")
    }
  }
}