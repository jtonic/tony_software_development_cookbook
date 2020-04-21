package com.nstanciu.tutorials.mn.surveys

import io.micronaut.context.annotation.Value
import javax.inject.Singleton

@Singleton
class ConfBean(
  @Value("\${cli.name}") private val name: String,
  @Value("\${cli.version}") private val version: String
) {

  fun getConf() =
    """
      Configuration of the `${name}`:
      - version: $version
    """.trimIndent()
}