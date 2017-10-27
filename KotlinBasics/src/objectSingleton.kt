object Validations{
    fun validatePassword(password: String) : Boolean = password.isNotEmpty() && password.length > 10

    fun isNumber(dataInput: Any) = dataInput is Int
}

class UniversalClass {
    companion object {
        fun create(): UniversalClass = UniversalClass()
    }
}

fun main(args: Array<String>) {
    println("Enter your password: ")
    val password: String = readLine()!!
    println(Validations.validatePassword(password))

    println("Enter a number: ")
    try{
        val number: Any = readLine()?.toInt() ?: ""
        println(number)
        println(Validations.isNumber(number))
    } catch (e: NumberFormatException){
        println(e)
    }

    val universalClassInMain = UniversalClass.create()
}

fun dataExample(){
    val universalClassData = UniversalClass.create()
}