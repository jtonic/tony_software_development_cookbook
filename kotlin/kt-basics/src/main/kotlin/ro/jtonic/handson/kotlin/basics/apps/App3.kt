package ro.jtonic.handson.kotlin.basics.apps

fun main(vararg args: String) {
    val name = if (args.isEmpty()) {
        "Kotlin"
    } else {
        args[0]
    }
    println("Hello $name!!!")
}
