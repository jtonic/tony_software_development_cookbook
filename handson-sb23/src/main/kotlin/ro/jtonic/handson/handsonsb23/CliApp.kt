package ro.jtonic.handson.handsonsb23

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder

@SpringBootApplication
class CliApp

fun main(args: Array<String>) {

  SpringApplicationBuilder(CliApp::class.java).run(*args)
}
