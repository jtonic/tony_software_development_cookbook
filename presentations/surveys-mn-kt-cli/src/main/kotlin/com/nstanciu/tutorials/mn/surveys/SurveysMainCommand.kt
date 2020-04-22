package com.nstanciu.tutorials.mn.surveys

import io.micronaut.configuration.picocli.PicocliRunner
import org.slf4j.Logger
import org.slf4j.LoggerFactory
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

    @Option(names = ["-a", "--all"], description = ["Print all surveys. This is the default switch"])
    private var allSurveys : Boolean = false

    override fun run() {
        when {
          conf -> println(this.confBean.getConf())
          allSurveys -> {
            val allSurveys = this.client.getAllSurveys()
            LOG.info(allSurveys.toString())
          }
          else -> {
            val allSurveys = this.client.getAllSurveys()
            LOG.info(allSurveys.toString())
          }
        }
    }

    companion object {

      @JvmField
      val LOG: Logger = LoggerFactory.getLogger(SurveysMainCommand::class.java)
    }
}

fun main(vararg args: String) {
  PicocliRunner.run(SurveysMainCommand::class.java, *args)
}
