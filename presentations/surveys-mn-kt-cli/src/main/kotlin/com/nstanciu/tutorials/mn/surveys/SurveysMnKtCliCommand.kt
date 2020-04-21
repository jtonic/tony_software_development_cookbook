package com.nstanciu.tutorials.mn.surveys

import io.micronaut.configuration.picocli.PicocliRunner

import picocli.CommandLine.Command
import picocli.CommandLine.Option

@Command(name = "surveys-mn-kt-cli", description = ["Survey management"],
        mixinStandardHelpOptions = true)
class SurveysMnKtCliCommand : Runnable {

    @Option(names = ["-c", "--conf"], description = ["Print configuration"])
    private var conf : Boolean = false

    override fun run() {
        // business logic here
        if (conf) {
            println("Version: version")
        }
    }

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            PicocliRunner.run(SurveysMnKtCliCommand::class.java, *args)
        }
    }
}
