package Unit_4

import Unit_1.MyClass

fun main()  {

    ////////Лямбда функция////////

    //что такое лямбда? - это функция, при определении которой не нужно указывать ее имя
    val goodMorning = { println("Good morning!") }
    goodMorning()   //Good morning!

    //Передаем параметры
    //один параметр
    val saySomething = { message: String -> println(message) }
    saySomething("something")   //something

    //несколько параметров
    val multiply = { number: Int, multiplier: Int -> println(number * multiplier) }
    multiply(2, 3)   //6

    //Если в лямбде нужно сделать несколько операций, их нужно разнести по разным строкам
    val multipyAndDashes = { number: Int, multiplier: Int ->
        val result = number * multiplier
        val resultWithDashes = "-$result-"
        println(resultWithDashes)
    }
    multipyAndDashes(2, 3)  //-6-

    //Возвращаем результат
    //если выражение ничего не возвращает, то лямбда вернет Unit:
    val saySomething1 = { message: String -> println(message) }   //Unit
    val multiplyAndAddDashes = { number: Int, multiplier: Int -> number * multiplier }  //Int
    println(saySomething1)  //(kotlin.String) -> kotlin.Unit
    println(multiplyAndAddDashes)   //(kotlin.Int, kotlin.Int) -> kotlin.Intьбть и

    //Если у нас многострочная лямбда, то она возвращает то, что указано в последней строке:
    val multiplyAndAddDashes1 = { number: Int, multiplier: Int ->
        val result = number * multiplier

        val multiplyAndAddDashes2 = { number: Int, multiplier: Int ->
            val result = number * multiplier
            println(result)
            result
        } //А вот так уже Int
        println(multiplyAndAddDashes2)  //(kotlin.Int, kotlin.Int) -> kotlin.Int

    }

    ///////Функции высшего порядка///////

    // принимают в качестве параметров другие функции, либо возвращают функцию как результат:
    fun higherOrderFunction(
        n1: Int,
        n2: Int,
        operation: (Int, Int) -> Int
    ) {   //передаем два параметра на вход и тип функцию(входные параметры которой - два Int значения, возвращаемое значение - Int)
        val result = operation(n1, n2)
        println(result) //6     //8     //2
    }

    val sum = { a: Int, b: Int -> a + b }
    val result = higherOrderFunction(4, 2, sum)
    println(result) //kotlin.Unit

    val multiply1 = { a: Int, b: Int -> a * b }
    val result1 = higherOrderFunction(4, 2, multiply1)
    println(result1)    //kotlin.Unit

    //лямбда как последний параметр
//    val result2 = higherOrderFunction(4, 2, {a, b -> a/b}) - лямбда стоит последним параметром, ее можно вынести за скобки
    val result2 = higherOrderFunction(4, 2) { a, b -> a / b }

    //лямбда с одним параметром
    //Когда у лямбды один параметр, мы можем его явно не указывать, а обращаться к нему по ключевому слову it:
    val list = listOf(1, 2, 3, 4)
    list.forEach {
        println(it)
    }
    //то-же самое в стандартном исполнении:
    val list1 = listOf(1, 2, 3, 4)
    list1.forEach { number ->
        println(number)
    }

    //type alias - псевдоним типов
//    typealias MyClassList = List<MyClass_1>   //Чтобы расскоментировать, нужно вывести вне метода main и создать класс MyClass_1
    //можно использовать с дженериками
//    typealias  MyClassTable<K> = MutableMap<K, MutableList<MyClass_1>>

    //Теперь, когда нам в коде понадобятся какие-то типы, мы сможем их вызывать вот так:
    //с псевдонимом:
//    val listWithAlias = mutableListOf<MyClassList>()
    //без псевдонима:
//    val listWithoutAlias = mutableListOf<List<MyClass_1>>()

    //также можно объявлять псевдонимы для лямбд:
//    typealias  Predicate<T> = (T)->Boolean

    //псевдонимы не создают новый тип, они равны базовым типам:
    //Когда у нас есть typealias Predicate<T> из прошлого примера, и мы используем Predicate<String>,
    // то компилятор всегда будет это преобразовывать в (String) -> Boolean.
//    val p:Predicate<String> = {it.contains("12")}
//    println(listOf("Piers12", "Piers13").filter(p)) //выведет [Piers 12]

    //Захват данных лямбдой - возврат лямбды из функции
    println("Захват данных функцией:")
    val ct = clousureTest()
    val ct2 = clousureTest()
//    ct()    //1   -для val x
    ct()
    ct()
    ct()

    ct2()
    ct2()
    ct2()
    ct2()


    //Деструктуризация:
    //Рестркутуризация работает не со всеми классами. Например, если у класса Person убрать data, тогда мы не сможем осуществить реструктуризацию, так как отсутсвует component1(). У data классов эти методы определены по-умолчанию. Также она хорошо работает с Map. Для всего остального нужно будет определять эти методы
    createAndPrintPerson("Tom", 25 ) {  (name) ->  //(а) после фигурной скобки пишем в круглых скобках параметры, т.о мы разбиваем на параметры
//        println("name: ${it.name}, age: ${it.age}")
//        println("name: $name, age: $age") //и теперь мы можем сделать обращение без ключевого слова it
        //что если нам нужны не все параметры?
        println("name: $name")  //неиспользованное поле в таком случае помечается нижним подчеркиванием "_". Если неиспользуемое поле будет в конце параметров - его можно удалить (строка а)
    }
}

fun clousureTest(): () -> Unit {    //возвращаемый тип - лямбда (в данном случае ничего не принимаем в параметры, и ничего не возвращаем)
//    val x = 1
//    val lambda = {println(x)}
    var x = 1
    val lambda = {println(++x)}
    return lambda
}

data class Person (val name:String, val age:Int)

fun createAndPrintPerson(name: String, age: Int, operation: (Person)-> Unit) {
    val person = Person(name, age)
    operation(person)
}