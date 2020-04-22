package com.nstanciu.tutorials.mn.surveys.model

import java.time.LocalDateTime
import java.util.UUID
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class Survey(
  private val id: UUID? = null,
  private val name: @Size(min = 2) String? = null,
  private val description: @Size(min = 2) String? = null,
  private val category: @NotBlank String? = null,
  private val endDate: LocalDateTime? = null,
  private val questions: List<Question>? = null
)
