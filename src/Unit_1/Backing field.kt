package Unit_1d

fun main() {
    val myClass2 = MyClass2()
    //  println(myClass2.name)  //выдаст ошибку, что нельзя взять имя getName
    println(myClass2.name1)
}

class MyClass2 {
    //с точки зрения Java, такая конструкция не вызовет подозрений:
    var name : String   //backing field generated - в Kotlin все переменные по умолчанию property (когда у поля есть геттер и сеттер)
    get() = name
    set(value : String) {
        name = value
    }
    //println(name)
    //но IDE предупреждает о рекурсивном вызове. То-есть в Kotlin:
    //myClass2.name = "Tom"
    //то-же, что в Java:
    //myClass.setName("Tom");
    //то-есть, когда в Java мы делаем:
    //myClass.setName("Tom");
    //это эквивалентно:
    //set(value) {name = value}
    //получается, что мы вызываем сеттер внутри сеттера
    //Чтобы решить эту проблему, придумали backing field:
    var name1 : String = "Bob"
    get() = field //чтобы получить доступ к backing field, надо просто обратиться к переменной, используя ключевое слово field
    set(value) {field = value}

}