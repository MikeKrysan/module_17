package Unit_1

fun main() {
    val kingdom1 = Kingdom_1()

    println("name: ${kingdom1.ruler1.name},  power: ${kingdom1.ruler1.power_1}, inteligance: ${kingdom1.ruler1.inteligence_1}")

    kingdom1.hair1.forEach{
        println("name: ${it.name}, power: ${it.power_1}, inteligance: ${it.inteligence_1}")
    }

    println(kingdom1.archer1)
    println(kingdom1.warrior1)
}

class Kingdom_1 {
    val ruler1 = Ruler_1("Mike")
    val hair1 = mutableListOf<Hair_1>()
    val archer1 = mutableListOf<Archer_1>()
    val warrior1 = mutableListOf<Warrior_1>()
    val whelloffortune1 = WhellOfFortune_1()

    init{
        for(i in 1..4) {
            hair1.add(Hair_1("Hair $i", whelloffortune1))
        }

        for(i in 0..19) {
            if(i%2==0) {
                archer1.add(Archer_1("Knife"))
            } else {
                archer1.add(Archer_1("None"))
            }
        }

        for(i in 0..29) {
            if(i%2 == 0) {
                warrior1.add(Warrior_1("Axe"))
            } else {
                warrior1.add(Warrior_1("Sword"))
            }
        }
    }
}
    open class Ruler_1(val name: String){
        var inteligence_1 = 10f
        var power_1 = 10f
    }

    class Hair_1(name:String, wheelOfFortune_1:WhellOfFortune_1) : Ruler_1(name) {
        init {
            power_1 = wheelOfFortune_1.coefficient_1()
            inteligence_1 = wheelOfFortune_1.coefficient_1()
        }
    }

    data class Archer_1(val bow: String = "Longbow", val knife: String) {
        constructor(knife: String):this("Longbow", knife)
    }

    data class Warrior_1(val weapon_1:String)

    class WhellOfFortune_1 {
        fun coefficient_1():Float {
            return (0..200).random()/100f
        }
    }
