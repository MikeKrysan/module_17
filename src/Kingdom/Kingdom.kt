package Unit_2

import Kingdom.Occupation
import Kingdom.Peasant
import Kingdom.TaxCollector



fun main() {
    val kingdom = Kingdom()

    println("name: ${kingdom.ruler.name} intellect: ${kingdom.ruler.intellect} power: ${kingdom.ruler.power}")

    kingdom.heirs.forEach(){
        println("name: ${it.name} intellect: ${it.intellect} power: ${it.power}")
    }

    println(kingdom.addArchers(19))
    println(kingdom.warriors)

    //2.7 реализуем сбор налогов в королевстве:
    val workerTaxCollector = object: TaxCollector() {
        override fun collect() {
            val taxGroup = kingdom.peasants.filter {
                it.occupation == Occupation.WORKER
            }
            kingdom.treasury +=taxGroup.size
        }
    }

    val builderTaxCollector = object: TaxCollector() {
        override fun collect() {
            val taxGroup = kingdom.peasants.filter {
                it.occupation == Occupation.BILDER
            }
            kingdom.treasury +=taxGroup.size*2
        }
    }

    val farmerTaxCollector = object: TaxCollector() {
        override fun collect() {
            val taxGroup = kingdom.peasants.filter {
                it.occupation == Occupation.FARMER
            }
            kingdom.treasury +=taxGroup.size*3
        }
    }

    workerTaxCollector.collect()
    builderTaxCollector.collect()
    farmerTaxCollector.collect()

    fun taxCalculation(groupSize: Int, multiplier: Int): Int = groupSize * multiplier   //3.2 One line функция, которая будет считать, сколько каждый сборщик налогов собрал со своей группы

    //2.8 Глашатай озвучивает присутсвие короля, а также смотрим на состояние нашей казны:
    Ruler.geroldGreetings() //Его Высокое Благородие Король в здании
    println("Gold: " + kingdom.treasury)    //Gold: 184

    fun String.yourHighness(amount: Int = 1) = "Ваше высочество!".repeat(amount) + this //3.3 К каждому обращению короля, добавляем "Ваше высочество!"

    fun <T> T.quickPrint(): T { //3.3 выводим на печать текст и плю
        println(this)
        return  this
    }

    "Ваша популярность падает!".yourHighness().quickPrint()
    "На нас напали!".yourHighness().quickPrint()
    "Нужно больше золота!".yourHighness().quickPrint()
}

class Kingdom {

    val ruler = Ruler("Mike")
    val heirs = mutableListOf<Heir>()

    val archers = mutableListOf<Archer>()
    val warriors = mutableListOf<Warrior>()

    val peasants = mutableListOf<Peasant>() //2.1 добавили созданных крестьян в коллекцию

    var treasury: Int = 0   //2.6 Создали казну

    private val wheelOfFortune = WheelOfFortune()



    private fun addHeirs(amount: Int) { //3.1 Переносим инициализацию персонажей в методы
        for (i in 1..4) {
            heirs.add(Heir("Heir $i", wheelOfFortune))
        }
    }

    fun addArchers(amount: Int) {   //3.1
        for (i in 0..19) {
            if (i % 2 == 0) {
                archers.add(Archer("Dagger"))
            } else {
                archers.add(Archer("None"))
            }
        }
    }

    private fun addWarriors(amount: Int) {  //3.1
        for (i in 0..29) {
            if (i % 2 == 0) {
                warriors.add(Warrior("Sword"))
            } else {
                warriors.add(Warrior("Axe"))
            }
        }
    }

    private fun addPesants(amount: Int) {   //3.1
        for (i in 0..99) {   //2.3 Зовем крестьян
            when {
                i % 2 == 0 -> {
                    peasants.add(Peasant(Occupation.BILDER))
                }
                i % 3 == 0 -> {
                    peasants.add(Peasant(Occupation.FARMER))
                }
                else -> {
                    peasants.add(Peasant(Occupation.WORKER))
                }
            }
        }
    }

}

    open class Ruler(val name: String) {
        var intellect = 10f
        var power = 10f

        companion object {  //2.4  у каждого короля должен быть герольд, все должны знать, что король с здании. Притом герольд это может объявлять, даже когда короля еще нет в здании
            fun geroldGreetings(){
                println("Его Высокое Благородие Король в здании")
            }
        }
    }

    class Heir(name: String, wheelOfFortune: WheelOfFortune) : Ruler(name) {
        init{
            power *=wheelOfFortune.coefficient()
            intellect *=wheelOfFortune.coefficient()
        }
    }

    data class Archer(val bow: String = "Longbow", val Dagger: String) {
        constructor(dagger:String):this("Longbow", dagger)
    }

    data class Warrior(val weapon: String)

    class WheelOfFortune {
        fun coefficient():Float = (0..200).random()/100f
    }
