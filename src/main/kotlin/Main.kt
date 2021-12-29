fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    // https://blog.jetbrains.com/kotlin/2020/07/kotlin-1-4-m3-generating-default-methods-in-interfaces/
    val prod = BirdPerson()
    val dele = DelegatedAlien(prod)
    println("It speaks like alien language: " + dele.originSpeak())
    println("It speaks like human language: " + dele.humanSpeak())

    // https://kotlinlang.org/docs/whatsnew14.html#unified-exception-type-for-null-checks
    var a: String? = "to be null"
    if(true) a = null
    try {
        println("Trying to call with null: ${nullCall(a)}")
    } catch (e: Exception) {
        println("Exception ocurred! the class is: ${e.javaClass}")
    }

}

fun nullCall(a: String?): Int {
    return a!!.length
}