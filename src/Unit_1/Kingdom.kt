package Unit_1


fun main() {
    val kingdom = Kingdom()

    println("name: ${kingdom.ruler.name} intellect: ${kingdom.ruler.intellect} power: ${kingdom.ruler.power}")

    kingdom.heirs.forEach{
        println("name: ${it.name} intellect: ${it.intellect} power: ${it.power}")
    }

    println(kingdom.archers)
    println(kingdom.warriors)
}

class Kingdom {

    val ruler = Ruler("Mike")
    val heirs = mutableListOf<Heir>()

    val archers = mutableListOf<Archer>()
    val warriors = mutableListOf<Warrior>()

    private val wheelOfFortune = WheelOfFortune()

    init {
        for (i in 1..4) {
            heirs.add(Heir("Heir $i", wheelOfFortune))
        }

        for (i in 0..19) {
            if (i % 2 == 0) {
                archers.add(Archer("Dagger"))
            } else {
                archers.add(Archer("None"))
            }
        }

        for (i in 0..29) {
            if (i % 2 == 0) {
                warriors.add(Warrior("Sword"))
            } else {
                warriors.add(Warrior("Axe"))
            }
        }

    }
}

    open class Ruler(val name: String) {
        var intellect = 10f
        var power = 10f
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
