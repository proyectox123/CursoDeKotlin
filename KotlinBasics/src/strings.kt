fun main(args: Array<String>) {
    val str = "This is an example about String."
    println(str)

    val name = "Mau"
    val age = 26

    val sentence = "Hi, I'm $name and I'm $age years old."
    println(sentence)

    val birthday = "$name turned ${age+1}"
    println(birthday)

    val text = """
        >This is a long string,
        >it's just and example that contains many lines.
        >Don't wory about it :P
        """.trimMargin(">")
    println(text)
}