package com.nstanciu.tutorials.mn.surveys

import com.nstanciu.tutorials.mn.surveys.model.Survey
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

@Client("http://localhost:8080/surveys")
interface SurveyClient {

    @Get
    fun getSurveys(): List<Survey>
}