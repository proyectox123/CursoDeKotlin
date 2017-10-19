class Example{
    fun hello(){
        println("Hello Kotlin")
    }
}

//class Person constructor(val name: String){
//
//}

class Person(val name: String){
    init{
        println("Name $name")
    }

    constructor(name: String, age: Int) : this(name){
        println("Name $name, age $age")
    }
}

open class Base(val initial: Int){
    open fun printSomething(){
        println("Something $initial")
    }
}

class General(val aux: Int) : Base(aux){
    override fun printSomething() {
        super.printSomething()
        val sum = 4 + aux
    }
}

fun main(args: Array<String>) {
    val person = Person("LeMau", 26)
    println(person)
    /*Name LeMau
      Name LeMau, age 26
      Person@266474c2*/
    val general = General(9)
    general.printSomething()
}

