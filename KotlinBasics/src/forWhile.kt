fun main(args: Array<String>) {
    forExamples()
    whileExamples()
}

private fun forExamples(){
    val numberList = intArrayOf(1, 2, 3, 4, 5, 6)
    for (i in numberList.indices){
        println(numberList[i])
    }

    val fruitList = listOf("Apple", "Pineapple", "Grape", "Banana")
    for(fruit in fruitList){
        println(fruit)
    }
}

private fun whileExamples(){
    var x = 3
    while(x > 0){
        x--
        println(x)
    }

    var sum: Int = 0
    var input: String? = ""

    do {
        print("Input number: ")
        input = readLine()
        sum += input?.toInt() ?: 0
    } while (input != "0")

    println("Sum is: $sum")
}