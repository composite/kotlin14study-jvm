import io.kotlintest.specs.StringSpec
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

class Kotlin15Test : StringSpec() {
    init {
        // https://kotlinlang.org/docs/whatsnew15.html#sam-adapters-via-invokedynamic
        "SAM adapters via invokedynamic" {
            val runnable = Runnable { println("This runs in a runnable") }
            runnable.run()
            val executor = ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, ArrayBlockingQueue(1))
            // Java signature: void execute(Runnable command)
            executor.execute { println("This runs in a thread pool") }
            executor.execute(Runnable { println("This also runs in a thread pool") })

            // Creating an instance of a class
            val isEven1 = object : IntPredicate {
                override fun accept(i: Int): Boolean {
                    return i % 2 == 0
                }
            }

            // Creating an instance using lambda
            val isEven2 = IntPredicate { it % 2 == 0 }

            println("Is 6 even? - ${isEven1.accept(6)}")
            println("Is 7 even? - ${isEven1.accept(7)}")

        }

        // https://kotlinlang.org/docs/whatsnew15.html#improvements-to-handling-nullability-annotations
        "Improvements to handling nullability annotations" {

            val list = ArrayList<String>() // non-null (constructor result)
            list.add("Item")
            val size = list.size // non-null (primitive int)
            val item = list[0] // platform type inferred (ordinary Java object)

            val nullable: String? = item // allowed, always works
            val notNull: String = item // allowed, may fail at runtime

        }

        // https://circlee7.medium.com/java8-lambda-%EB%9E%8C%EB%8B%A4-%ED%91%9C%ED%98%84%EC%8B%9D%EC%9D%98-%EB%8F%99%EC%9E%91-%EC%9D%B4%ED%95%B4-cf5342eeb5ac
    }
}

fun interface IntPredicate {
    fun accept(i: Int): Boolean
}

interface Robot {
    fun move() { println("~walking~") }  // will be default in the Java interface
    fun speak(): Unit
}