package Unit_2

fun main() {
    println(Weapons.SWORD)
    println(Weapons_1.SWORD.profession)
    println(Weapons_2.SWORD.getElite(true))
}

enum class Weapons {
    SWORD,
    DAGGER,
    STAFF,
    BOW
}

enum class Weapons_1(val profession: String) {
    SWORD("warrior"),
    DAGGER("rouge"),
    STAFF("mage"),
    BOW("archer")
}

enum class Weapons_2(val profession: String) {
    SWORD("warrior"),
    DAGGER("rouge"),
    STAFF("mage"),
    BOW("archer");

    fun getElite(isElite: Boolean) =
        if(isElite) {
            "elite $profession"
        } else {
            profession
        }
}