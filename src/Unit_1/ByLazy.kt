package Unit_1
//by lazy - ленивая инициализация. Переменная будет инициализированна тогда, когда она где-то понадобится
fun main() {
    val myClass1 = MyClass1()

    println(myClass1.name1) //Martin
}

class MyClass1 {
    val name1: String by lazy { //Важный момент: тип переменной должен быть val
        "Martin"
    }
}