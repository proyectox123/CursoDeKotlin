fun main(args: Array<String>) {
    val arrayA = intArrayOf(1, 2, 3, 4, 5, 6)
    val listA = arrayListOf("Hello", "Kotlin", "Java", "Android")

    val num = arrayA[0]
    arrayA[2] = 10

    val mutableList = mutableListOf(2, 3, 4, 5, 6, 7)
    mutableList.add(9)
    mutableList.add(2, 10)
    mutableList[0] = 1

    val map = mutableMapOf<String, Int>(Pair("Key", 30))
    map.put("key2", 40)
}