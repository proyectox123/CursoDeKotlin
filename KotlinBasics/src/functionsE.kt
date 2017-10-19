fun hello() {
    println("Hello everybody!")
}

fun sum(a: Int, b: Int){
    println("The sum between $a and $b is ${a+b}")
}

//fun max(a: Int, b: Int): Int{
//    when {
//        a > b -> return a
//        else -> return b
//    }
//}

//fun max(a: Int, b: Int): Int{
//    return when {
//        a > b -> a
//        else -> b
//    }
//}

fun max(a: Int, b: Int) = if (a>b) a else b

fun main(args: Array<String>) {
    println(max(4, 1))
}