data class Familiar(val name: String = "Mau", val age: Int = 26, val colorHair: String = "brown")

data class Result(val result: Int, val status: Boolean)

fun calculate(a: Int, b: Int): Result = if(a * 2 > b){
        Result(a * 2, true)
    }else{
        Result(a, false)
    }

fun main(args: Array<String>) {
    var (name, _, colorHair) = Familiar()
    println(name)
    println(colorHair)

    val (result, status) = calculate(4, 9)
    println(result)
    println(status)
}