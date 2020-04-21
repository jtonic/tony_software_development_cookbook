package com.nstanciu.tutorials.mn.surveys

import io.micronaut.configuration.picocli.PicocliRunner
import io.micronaut.context.ApplicationContext
import io.micronaut.context.env.Environment
import org.junit.jupiter.api.Assertions.assertTrue
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import java.io.ByteArrayOutputStream
import java.io.PrintStream

object SurveysMnKtCliCommandTest : Spek({

    describe("surveys") {
        val ctx = ApplicationContext.run(Environment.CLI, Environment.TEST)

        context("invocation with -c") {
            val baos = ByteArrayOutputStream()
            System.setOut(PrintStream(baos))

            val args = arrayOf("-c")
            PicocliRunner.run(SurveysMnKtCliCommand::class.java, ctx, *args)

            it("should display greeting") {
                assertTrue(baos.toString().contains("Configuration"))
            }
        }
    }
})
