fun main(args: Array<String>) {
    for(i in 1..4){
        println(i)
    }

    println("************************")

    for(i in 4 downTo 1){
        println(i)
    }

    println("************************")

    for(i in 1..4 step 2){
        println(i)
    }

    println("************************")

    for(i in 4 downTo 1 step 2){
        println(i)
    }

    println("************************")

    for(i in 1 until 10){
        println(i)
    }

    println("************************")
    val isEleven = (1..12 step 2).last == 11
    println(isEleven)
}