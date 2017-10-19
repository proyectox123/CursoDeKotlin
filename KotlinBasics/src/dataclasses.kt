data class Auto(var brand: String, private var doors: Int){
    var numDoors = doors
    get(){
        return if (field > 0) field else 1
    }
}

data class Person2(var name: String, val age: Int, val eyesColor: String)

fun main(args: Array<String>) {
    val auto = Auto("Ford", 0)

    val brand = auto.brand
    println("Brand $brand")

    auto.brand = "Chevrolet"
    println("Brand auto $auto.brand")

    auto.numDoors = 3

    auto.hashCode()
    println(auto.toString())
    println(auto.numDoors)
    /*Brand Ford
    Brand auto Auto(brand=Chevrolet).brand
    Auto(brand=Chevrolet)*/

    val leMau = Person2("LeMau", 26, "brown")
    val leMauClone = leMau.copy("LeMauClone")

    println(leMau)
    println(leMauClone)
    println("**********************")

    val leMauBrother = leMau
    leMauBrother.name = "LeMauBrother"

    println(leMau)
    println(leMauClone)
    println(leMauBrother)
    /*Person2(name=LeMau, age=26, eyesColor=brown)
    Person2(name=LeMauClone, age=26, eyesColor=brown)
    **********************
    Person2(name=LeMauBrother, age=26, eyesColor=brown)
    Person2(name=LeMauClone, age=26, eyesColor=brown)
    Person2(name=LeMauBrother, age=26, eyesColor=brown)*/
}