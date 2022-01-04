fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    println("invokedynamic string concatenation")
    println()
    println(InvokedynamicStringConcatenation.concatenation1())
    println(InvokedynamicStringConcatenation.concatenation2())
    println(InvokedynamicStringConcatenation.concatenation3())
    println()
    println("Extensions for java.nio.file.Path")
    println()
    println("JavaNioPathExtension.getDirList:\n" + JavaNioPathExtension.getDirList())
    println("JavaNioPathExtension.getSubTextFile:\n" + JavaNioPathExtension.getTextFile())
    println()
    println("Improved String.replace function performance")
    println()
    println("replaceSensitive: " + StringReplace.replaceSensitive())
    println("replaceInsensitive: " + StringReplace.replaceInsensitive())

    println("study finish?")
}