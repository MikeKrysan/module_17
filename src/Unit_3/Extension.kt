package Unit_3

fun main(){
//    print("Wake up".addUrgent(10))
//    "Wake up".addUrgent(10).quickPrint()    //Wake up!!!!!!!!!!
    "Wake up".quickPrint1().addUrgent(10).quickPrint1()   //Wake up
                                                                // Wake up!!!!!!!!!!
    20.quickPrint1() //20
    20.sqrt.quickPrint1()    //400
    Any().quickPrint1()  //java.lang.Object@27973e9b

//    val string: String? = null
//    string.defaultIfNull("Wow") //Wow

    val string: String? = "Hello"
    string.defaultIfNull("Wow") //Hello
}

fun String.addUrgent(amount: Int = 1) = this + "!".repeat(amount)

//fun Any.quickPrint() = println(this)

fun <T> T.quickPrint1(): T {
    println(this)
    return  this
}

//Extension properties
val Int.sqrt
    get() = this * this

fun String?.defaultIfNull(default: String) = println(this?:default)