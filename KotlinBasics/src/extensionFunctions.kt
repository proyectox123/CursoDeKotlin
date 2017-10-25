fun main(args: Array<String>) {
    "Hi, my name is Mau".print()
    println(4.multiply(2))
    println(4 multiply 2)

    val nameList = mutableListOf("Zelt", "Rodrigo", "Amaury", "Ángel")
    nameList.swap(0, 2)
    println(nameList.toString())
}

fun <T> MutableList<T>.swap(index1: Int, index2: Int){
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}

infix fun Int.multiply(numM: Int): Int{
    return this * numM
}

fun String.print(){
    println(this)
}