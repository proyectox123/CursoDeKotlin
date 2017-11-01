sealed class Intention{
//    class Refresh: Intention()
//    class Reload: Intention()
    object Refresh:Intention(){
        override fun log() {
            println("Refreshing")
        }
    }

    object LoadMore:Intention(){
        override fun log() {
            println("Load more data")
        }
    }

    data class Error(val reason: String):Intention(){
        override fun log() {
            println("Error: $reason")
        }
    }

    abstract fun log()
}

fun main(args: Array<String>) {
//    val intention: Intention = Intention.Reload()
//
//    val output = when(intention){
//        is Intention.Refresh -> "Refresh"
//        is Intention.Reload -> "Reload"
//    }
//
//    println(output)
    val intention: Intention = Intention.LoadMore
    val output = when(intention){
        is Intention.LoadMore -> "Load more"
        is Intention.Refresh -> "Refresh"
        is Intention.Error -> "Error"
    }

    intention.log()

    println(output)
}