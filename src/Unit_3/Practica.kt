package Unit_3

fun main() {
    println(nothingToReturn())  //kotlin.Unit(хот-кей: ctrl+shift+P)
    printDigits(1, 2) //1, 2
    printDigits(b = 2, a = 1) //1, 2

    val c = function2(2, 4)

}

private fun nothingToReturn() {}

//Named parameters
fun printDigits(a: Int, b: Int) {
    println("$a, $b")
}

////////Виды и варианты написания функций////////
//One line functions
private fun function(a: Int, b: Int) = a + b

private fun function1(a: Int, b: Int) = //single expression = one line functions
    if (a > b) {
        a
    } else {
        b
    }

//Inline functions - при декомпиляции в Java в методе main() не происходит вызов нашего метода, а вставлен код из метода function2
//Это делается для производительности, однако увеличивается объем кода. По настоящему inline себя показывает с лямбдами
inline fun function2(a: Int, b: Int) = a + b

//Noinline - можно пометить функцию, которая находится внутри функции, которая помечена inline
//inline fun sum(
//    num: Int,
//    lambda1: (result: Int) -> Unit, //для lambda1 - не будет
//    noinline lambda2: () -> Unit    //для lambda2 будет создан класс при декомпиляции
//): Int {//...}
