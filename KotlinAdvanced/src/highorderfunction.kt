fun sum(num: Int, num2: Int, func: () -> Unit){
    println("Sum between $num and $num2 = ${num + num2}")
    func()
}

fun String.functionRandom(func: String.() -> Unit){
    this.func()
    println(this.length)
}

fun main(args: Array<String>) {
//    sum(6, 8, func = {
//
//    })
    "Hello".functionRandom {
        println(length)
    }

    with("Hello"){
        println(length)
    }

    sum(6, 8) {
        println("High order function.")
    }
}