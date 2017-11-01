inline fun String.filter(predicate: (Char) -> Boolean): String{
    return filterTo(StringBuilder(), predicate).toString()
}

fun main(args: Array<String>) {
    val a = "Hello".filter {
        it == 'h'
    }

    println(a)
}
