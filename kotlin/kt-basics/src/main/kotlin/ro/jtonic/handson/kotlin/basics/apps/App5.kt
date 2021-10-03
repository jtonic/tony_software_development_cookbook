package ro.jtonic.handson.kotlin.basics.apps

fun main(args: Array<String>) {
    val name = if (args.isEmpty()) {
        "Kotlin"
    } else {
        args[0]
    }
    println("Hello $name!!!")
}
