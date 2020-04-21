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

//    @Client("http://localhost:8080")
//    @Inject
//    private lateinit var client: RxHttpClient

    @Inject
    private lateinit var client: GreetingClient

    @Option(names = ["-c", "--conf"], description = ["Print configuration"])
    private var conf : Boolean = false

    @Option(names = ["-a", "--all"], description = ["Print all surveys"])
    private var allSurveys : Boolean = false

    override fun run() {
        // business logic here
        when {
          conf -> println(this.confBean.getConf())
          allSurveys -> {
            val greet = this.client.greet()
            println(greet)
          }
/*
          allSurveys -> {
            val greet = this.client.retrieve(HttpRequest.GET<String>("/hello"), String::class.java).blockingFirst()
            println(greet)
          }
*/
        }
    }

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            PicocliRunner.run(SurveysMainCommand::class.java, *args)
        }
    }
}
