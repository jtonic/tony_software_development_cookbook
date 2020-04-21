package com.nstanciu.tutorials.mn.surveys.model

import io.micronaut.core.annotation.Introspected
import java.util.UUID

@Introspected
class Answer(
  private val id: UUID? = null,
  private val content: String? = null
)
