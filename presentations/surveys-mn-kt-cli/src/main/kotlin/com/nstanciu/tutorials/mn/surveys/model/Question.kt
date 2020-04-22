package com.nstanciu.tutorials.mn.surveys.model

import java.util.UUID

data class Question (
  private val id: UUID? = null,
  private val content: String? = null,
  private val answers: List<Answer>? = null,
  private val correctAnswer: UUID? = null
)
