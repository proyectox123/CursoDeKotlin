fun main(args: Array<String>) {
    val a: String = "abc"

    var b: String? = "abc"
    b = null

    val l1 = a.length
    val l2 = b?.length ?: 0

    println(l1)
    println(l2)

    val person: Person2? = Person2("Mau", 26, "brown")
    val name = person?.name

    person?.let {
        //initialized person
    }

    person.let {
        //null
    }
}