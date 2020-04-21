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

    @Option(names = ["-c", "--conf"], description = ["Print configuration"])
    private var conf : Boolean = false

    override fun run() {
        // business logic here
        if (conf) {
            println(this.confBean.getConf())
        }
    }

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            PicocliRunner.run(SurveysMainCommand::class.java, *args)
        }
    }
}
