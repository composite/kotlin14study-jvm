import kotlin.io.path.*

// https://kotlinlang.org/docs/whatsnew1420.html#invokedynamic-string-concatenation
open class InvokedynamicStringConcatenation {
    companion object {
        @JvmStatic
        fun concatenation1() : String {
            val a = "kotlin "
            val b = "1.4.20"
            return a + b
        }
        @JvmStatic
        fun concatenation2() : String {
            val a = "kotlin "
            val b = "1.4.20"
            return a.plus(b)
        }
        @JvmStatic
        fun concatenation3() : String {
            val a = "kotlin "
            val b = "1.4.20"
            return (a::plus)(b)
        }
    }

}

// https://kotlinlang.org/docs/whatsnew1420.html#extensions-for-java-nio-file-path
open class JavaNioPathExtension {
    @OptIn(ExperimentalPathApi::class)
    companion object {
        @JvmStatic
        fun getDirList() : String {
            val base = Path("")
            return base.listDirectoryEntries("*").joinToString("\n") { it.toString() }
        }
        @JvmStatic
        fun getTextFile() : String {
            val base = Path("")
            val sub = base / "README.md"
            return sub.readText()
        }
    }
}

// https://kotlinlang.org/docs/whatsnew1420.html#improved-string-replace-function-performance
// https://discuss.kotlinlang.org/t/string-replace-implementation-is-very-poor/19026/22
// https://youtrack.jetbrains.com/issue/KT-41799
open class StringReplace {
    companion object {
        @JvmStatic
        fun replaceSensitive() : String {
            return "Java is not javascript!".replace("java", "groovy").replace("Java", "kotlin")
        }
        @JvmStatic
        fun replaceInsensitive() : String {
            return "Java is not javascript!".replace("java", "kotlin", true)
        }
    }
}