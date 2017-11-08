data class Time(val years: Int, val days: Int)

operator fun Time.plus(other: Time): Time{
    return Time(this.years + other.years, this.days + other.days)
}

data class Counter(var  index: Int){
    operator fun inc(): Counter {
        return Counter(index + 1)
    }
}

fun main(args: Array<String>) {
    val time1 = Time(2000, 30)
    val time2 = Time(100, 2)

    val timeSum = time1 + time2

    println(timeSum)

    var counter = Counter(5)
    println(counter.inc())
    println(++counter)
}