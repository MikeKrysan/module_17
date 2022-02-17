package Unit_1

fun main() {
//    val predator = Predator() //1
//    predator.eat()
}

interface Animal {
    fun eat()
}

class AnimalImpl : Animal {
    override fun eat() {
        println("eating..")
    }
}

class Predator(animalImpl: AnimalImpl) : Animal by animalImpl

/*
1.вы используете делегат на уровне класса, в этом случае нельзя сделать конструктор без параметра.
В остальных случаях, чтобы можно было использовать конструктор без параметров, хотя они есть, нужно указывать дефолтные значения
 */