//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun printMessage(message: String): Unit {                               // 1
    println(message)
}

fun printMessageWithPrefix(message: String, prefix: String = "Info") {  // 2
    println("[$prefix] $message")
}
fun printNumbers (num: Int): Unit {
    for (i in 0 .. num){
        println("i = $i")
    }
}
fun sum(x: Int, y: Int): Int {                                          // 3
    return x + y
}

fun multiply(x: Int, y: Int) = x * y                                    // 4

fun main() {

    var neverNull: String? = "This can't be null"            // 1

//    neverNull = null                                        // 2

    var nullable: String? = "You can keep a null here"      // 3

    nullable = null                                         // 4

    var inferredNonNull = "The compiler assumes non-null"   // 5

//    inferredNonNull = null                                  // 6

    fun strLength(notNull: String): Int {                   // 7
        return notNull.length
    }

//    strLength(neverNull)                                    // 8
//    strLength(nullable)



    fun printAll(vararg messages: String){
        for (m in messages) println(m)
    }
    printAll("Hello", "Herro", "Hi", "Hey")
    printMessage("Hello")                                               // 5
    printMessageWithPrefix("Hello", "Log")                              // 6
    printMessageWithPrefix("Hello")                                     // 7
    printMessageWithPrefix(prefix = "Log", message = "Hello")           // 8
    println(sum(1, 2))                                                  // 9
    println(multiply(2, 4))
    printNumbers(5)// 10
    infix fun Int.times(str: String) = str.repeat(this)
    println(8 times "Bye")

    val pair = "Ferrari" to "Katrina"
    println(pair)

    infix fun String.onto(other: String) = Pair(this, other)
    val MyPair = "McLaren" onto "Lucas"
    println(MyPair)

    val sophia = Person("Sophia")
    val claudia = Person("Claudia")
    sophia likes claudia

//    operator fun Int.times(str: String) = str.repeat(this)
//    println(3 * "Bye")

    operator fun String.get(range: IntRange) = substring(range)
    val str = "012345678901234567890"
    println(str[0..14])

    fun printAllWithPrefix(vararg messages: String, prefix: String) {  // 3
        for (m in messages) println(prefix + m)
    }
    printAllWithPrefix(
        "Hello", "Hallo", "Salut", "Hola", "你好",
        prefix = "Greeting: "                                          // 4
    )
    fun log(vararg entries: String) {
        printAll(*entries)                                             // 5
    }
    log("Hello", "Hallo", "Salut", "Hola", "你好")
}

class Person(val name: String) {
    val likedPeople = mutableListOf<Person>()
    infix fun likes(other: Person) { likedPeople.add(other) }  // 6
}