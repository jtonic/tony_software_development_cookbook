package com.nstanciu.tutorials.mn.surveys.model

import java.util.UUID

data class Survey(
  val id: UUID? = null,
  val name: String? = null,
  val description: String? = null,
  val category: String? = null
)
