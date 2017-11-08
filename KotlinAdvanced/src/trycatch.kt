fun isNumber(data: Any?) = data is Int || data is Int?

fun fail(message: String): Nothing{
    throw IllegalArgumentException(message)
}

fun main(args: Array<String>) {
    //exampleNumberFormatException()

    var name = ""
    val person: PersonaKT? = null
    try{
        name = person?.nombre ?: fail("Required Name")
    } catch (e: IllegalArgumentException){
        println(e)
        println(name)
    }
}

private fun exampleNumberFormatException(){
    println("Enter any character: ")

    val number: Any? = try {
        readLine()?.toInt()
    }catch (e: NumberFormatException){
        "It's not an integer!"
    }

    println("Variable $number")
    println("Result: ${isNumber(number)}")
}