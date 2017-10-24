fun sayHello(hello: String = "Hello everybody!"){
    println(hello)
}

fun otherFunction(age: Int = 0, isAdult: Boolean = false, hasClothes: Boolean = true){
    println("age $age, isAdult $isAdult, hasClothes $hasClothes")
}

data class Class1(val a: Int = 2)

fun main(args: Array<String>) {
    sayHello("What's up!")
    sayHello()

    otherFunction()
    otherFunction(isAdult = true, age = 30)
    otherFunction(age = 30, hasClothes = true)
    otherFunction(hasClothes = true)
    otherFunction(isAdult = true, age = 30, hasClothes = true)

    val class1 = Class1()
}