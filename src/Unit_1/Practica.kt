package Unit_1

fun main() {
    val test = Test(1)
    // val test1 = Test(1)
    println(test.a + test.b)
    // println

    val predator1 = Predator1()   //1.4 Допустим нам нужна такая реализация в классе, по сути это паттерн Deligation
    predator1.initEat1()  //1.6 Работает, но много кода, посмотрим, как Kotlin это решит

//    val myClass = MyClass()
//    println(myClass.name)   //будет выброшено исключение UninitializedPropertyAccessException
    //чтобы такого не происходило, перед обращением к переменной lateinit ее нужно проинициализировать
    val myClass = MyClass()
    myClass.initName()

        println(myClass.name)   //Bob
}

//---------Конструкторы-------
class Test(val a: Int, val b: Int = 30) {
//    var first = 0
//    var second = 0
//    init{
//        first = a
//        second = b
//    }
//    constructor(a:Int): this(a,20)
}

//------Наследование-------
open class ParentClass
class ChildClass : ParentClass()

//------Делегация имплементации интерфейса  1
interface Animal1 {  //1.1 Создаем интерфейс
    fun eat1()   //1.2 метод, который должны будут реализовать все классы, которые будут применчять этот интерфейс
}

class AnimalImpl1 : Animal1 { //1.3 Реализуем интерфейс
    override fun eat1() {
        println("eating..")
    }
}

class Predator1 {    //1.5
    val animalImpl1 = AnimalImpl1()

    fun initEat1() {
        animalImpl1.eat1()
    }
}


class MyClass {
    //lateinit
    lateinit var name:String
    fun initName() {
        name = "Bob"
    }

    //by lazy

}