package Unit_2

fun main() {
    /////Реализация интерфейса без анонимности/////
//    val shooter1 = Shooter1(Pistol1())
//    shooter1.shooterGun1.shoot1()
//    shooter1.shooterGun1.reload1()

    //////Реализация интерфейса с помощью анонимного класса//////
    val bazookaShooter1 = Shooter1(object:Gun1 {    //Для того, чтобы использовать анонимные классы в Kotlin, нужно написать ключевое слово "object" : "имя интерфейса" {} - (1.)
        override fun shoot1() {
            println("Kaboom")
        }

        override fun reload1() {
            println("wank-wank")
        }

    })

    bazookaShooter1.shooterGun1.shoot1()
    bazookaShooter1.shooterGun1.reload1()
}

//class Pistol1 : Gun1 {
//    override fun shoot1() {
//        println("puff - puff")
//    }
//
//    override fun reload1() {
//        println("click - clack")
//    }
//}

class Shooter1(var shooterGun1: Gun1)

interface Gun1 {
    fun shoot1()
    fun reload1()
}

/*
1. С абстрактными классами та же история, только у абстрактных классов могут быть конструкторы open:

fun main() {

   val bazookaShooter = Shooter(object: Gun("armour piercing") {
       override fun shoot() {
           TODO("Not yet implemented")
       }

       override fun reload() {
           TODO("Not yet implemented")
       }

   })

   bazookaShooter.shooterGun.shoot()
   bazookaShooter.shooterGun.reload()
}

abstract class Gun(val ammoType: String) {
   open fun shoot() {}
   open fun reload() {}
}
 */