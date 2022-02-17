package Unit_1

fun main() {
    //Зачем нам нужен Data class?
    //1.  Переопределен метод toString()
    println(NoDataClassCharacter("Bob", "Mage"))    //Unit_1.NoDataClassCharacter@3b9a45b3
    println(Character("Martin", "Warrior")) //Character(name=Martin, profession=Warrior)

    //2. Переопределен метод equals/hashCode
    println(
        NoDataClassCharacter("Bob", "Mage") == NoDataClassCharacter(
            "Bob",
            "Mage"
        )
    ) //false - по умолчанию сравниваются ссылки на объекты. Метод equals() даст такой же результат
    // а в data class метод equals переопределен на сравнение полей, и если поля равны, то и объекты равны
    println(Character("Martin", "Warrior") == Character("Martin", "Warrior")) //true

    //есть метод copy(), который позволяет с легкостью сделать копию объекта Data class и даже поменять необходимые поля:
    val martinWarrior = Character("Martin", "Warrior")
    println(martinWarrior)  //Character(name=Martin, profession=Warrior)
    val martinArcher = martinWarrior.copy(profession = "Archer")
    println(martinArcher)   //Character(name=Martin, profession=Archer)

    //Destructuring declarations - разбиение полей класса на переменные. Data class позволяет это сделать без написания своей реализации этого функционала, достаточно просто написать:
    val martinWarrior1 = Character("Martin", "Archer")
    val (name, profession) = martinWarrior1
    println("name: $name profession $profession")   //name: Martin profession Archer

    /**
     * Также стоит отметить ограничения, которые накладываются при использовании Data class:

    В основном конструкторе должен быть хотя бы один параметр.
    Параметры основного конструктора должны быть помечены как val или var.
    Не может быть abstract, open, sealed, inner.

     */
}

data class Character(val name: String, val profession: String)

class NoDataClassCharacter(val name: String, val profession: String)

