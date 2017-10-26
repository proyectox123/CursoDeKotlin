fun main(args: Array<String>) {
    isMajor(6)

    defineType("Hey Ho!!!")
    defineType(Person2("Mau", 20, "brown"))
}

fun isMajor(data: Int) : Boolean =
    if(data > 0){
        println("$data")
        true
    }else{
        println("$data")
        false
    }

fun defineType(data: Any){
    if(data is String){
        println(data.length)
    } else if(data is Int){
        println("${data * 2}")
    } else if(data is Person2){
        println(data.name)
    }
}