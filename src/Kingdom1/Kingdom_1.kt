package Kingdom1

fun main() {
    val kingdom1 = Kingdom_1()

    println("name: ${kingdom1.ruler1.name},  power: ${kingdom1.ruler1.power_1}, inteligance: ${kingdom1.ruler1.inteligence_1}")

    kingdom1.hair1.forEach{
        println("name: ${it.name}, power: ${it.power_1}, inteligance: ${it.inteligence_1}")
    }

    println(kingdom1.archer1)
    println(kingdom1.warrior1)

    val workerTaxCollector1 = object: TaxCollector1() {
        override fun collect1() {
            val taxGroup1 = kingdom1.peasant1.filter{
                it.occupation1 == Occupation1.WORKER
            }
            kingdom1.kazna += taxGroup1.size
        }
    }

    val builderTaxCollector1 = object: TaxCollector1() {
        override fun collect1() {
            val taxGroup1 = kingdom1.peasant1.filter{
                it.occupation1 == Occupation1.BUILDER
            }
            kingdom1.kazna += taxGroup1.size*2
        }
    }

    val farmerTaxCollector1 = object :TaxCollector1() {
        override fun collect1() {
            val taxGroup1 = kingdom1.peasant1.filter {
                it.occupation1 == Occupation1.FARMER
            }
            kingdom1.kazna += taxGroup1.size*3
        }
    }

    workerTaxCollector1.collect1()
    builderTaxCollector1.collect1()
    farmerTaxCollector1.collect1()

    Ruler_1.glashataj()
    println("Gold: " + kingdom1.kazna)
}

class Kingdom_1 {
    val ruler1 = Ruler_1("Mike")
    val hair1 = mutableListOf<Hair_1>()
    val archer1 = mutableListOf<Archer_1>()
    val warrior1 = mutableListOf<Warrior_1>()
    val whelloffortune1 = WhellOfFortune_1()

    val peasant1 = mutableListOf<Peasant1>()

    var kazna: Int = 0

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

        for(i in 0..99) {
            when{
                i %2 == 0 -> {
                    peasant1.add(Peasant1(Occupation1.BUILDER))
                }
                i %3 == 0 -> {
                    peasant1.add(Peasant1(Occupation1.FARMER))
                }
                else -> {
                    peasant1.add(Peasant1(Occupation1.WORKER))
                }
            }
        }
    }
}
    open class Ruler_1(val name: String){
        var inteligence_1 = 10f
        var power_1 = 10f

        companion object {
            fun glashataj() {
                println("граф-барон фон Пуклер явился")
            }
        }
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
