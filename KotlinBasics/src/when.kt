fun type(data: Any){
    when(data){
        is String -> println(data.length)
        is Int -> println("Length ${data * 2}")
        is Boolean -> {
            println("It's a boolean")
            println(data)
        }
        is Person2 -> println("${data.name} ${data.age}")
        else -> println("I don't know what kind of data is")
    }
}

fun whoIs(person: Person2) =
    when(person.name){
        "Mau", "LeMau" -> "You can enter ${person.name}."
        else -> "Run!!!"
    }

fun range(number: Int){
    when(number){
        in 1..10 -> println("$number is a positive number with value between 1 and 10.")
        in 10..100 -> println("$number is a positive number with value between 10 and 100.")
        else -> println("$number is a number with value out of range.")
    }
}

fun main(args: Array<String>) {
    type(9)
    type("Mau")

    val Mau = Person2("Mau", 26, "brown")
    val leMau = Person2("LeMau", 25, "brown")
    val other = Person2("Other", 24, "brown")

    println(whoIs(Mau))
    println(whoIs(leMau))

    range(1)
    range(10)
    range(100)
}