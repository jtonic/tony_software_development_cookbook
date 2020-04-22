package com.nstanciu.tutorials.mn.surveys

import io.micronaut.configuration.picocli.PicocliRunner
import picocli.CommandLine.Command
import picocli.CommandLine.Option
import javax.inject.Inject

@Command(name = "surveys", description = ["Survey management cli"],
        mixinStandardHelpOptions = true)
class SurveysMainCommand : Runnable {

    @Inject
    private lateinit var confBean: ConfBean

    @Inject
    private lateinit var client: SurveysClient

    @Option(names = ["-c", "--conf"], description = ["Print configuration"])
    private var conf : Boolean = false

    @Option(names = ["-a", "--all"], description = ["Print all surveys"])
    private var allSurveys : Boolean = false

    override fun run() {
        when {
          conf -> println(this.confBean.getConf())
          allSurveys -> {
            val allSurveys = this.client.getAllSurveys()
            println(allSurveys)
          }
          else -> {
            val allSurveys = this.client.getAllSurveys()
            println(allSurveys)
          }
        }
    }
}

fun main(vararg args: String) {
  PicocliRunner.run(SurveysMainCommand::class.java, *args)
}
