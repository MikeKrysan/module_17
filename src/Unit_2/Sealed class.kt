package Unit_2
//sealed класс является абстрактным, конструктор изолированного класса должен быть приватным. В отличии от наследников sealed класса, наследники наследников sealed класса могуть быть использованы где угодно, не обязательно в том же файле
sealed class Car    //изолированный класс - у наследников изолированного класса может быть множество экземпляров

//Наследники изолированного класса должны быть объявлены в том же классе
class FastCar(var isFast:Boolean = false): Car() //Класс с одним булевым полем, унаследованный от Car
class SlowCar(var isFast:Boolean = false): Car() //Класс с одним булевым полем, унаследованный от Car

fun implementFastness(car:Car) {
    when(car) {                 //ключевое преимущество изолированных классов проявляется, когда мы используем выражение when:
        is FastCar -> car.isFast = true
        is SlowCar -> car.isFast = false
    }
}

fun main() {
    val fastCar = FastCar()
    implementFastness(fastCar)
    val slowCar = SlowCar()
    implementFastness(slowCar)

    println("Is fast car fast: ${fastCar.isFast}")  //Is fast car fast: true
    println("Is slow car fast: ${slowCar.isFast}")  //Is fast car fast: false
}