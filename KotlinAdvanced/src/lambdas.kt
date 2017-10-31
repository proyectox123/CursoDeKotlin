data class Auto(val color: String, val wheels: Int, val doors: Int)

fun main(args: Array<String>) {
    val num: Int? = null

    val result = sum(4, 7)
    println(result)

    val resultMinFour = minFour("Hola man")
    println(resultMinFour)

    val myAuto: Auto? = Auto("Red", 4, 4)
    myAuto?.let {
        with(it){
            doors
            color
            wheels
        }
    }
}

val sum:(Int, Int) -> Int = { x, y -> x + y }

val minFour:(String) -> Boolean = { it.length > 4 }