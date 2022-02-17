package Unit_2
//Для того, чтобы обращаться к полям и методам класса без создания экземпляра класса можно воспользоваться Companion object

//object:
object Constants{
    val PI = 3.14   //синглтон- присутсвует в приложении в одном экземпляре, обладает ленивой инициализацией
}

fun main() {
    println(Constants.PI)
    println(Amigo.tequila)
}

//объявление компанйона:
class Amigo {
    val sambuka = 0.5
    val totalAlchohol = sambuka + tequila   //класс, в котором объявлен Companion object, может использовать его поля
    companion object Hernandez{ //у одного класса может быть только один Companion object, поэтом давать имя ему не имеет смысла
        val tequila = 0.5   //создали синглтон с ленивой инициализацией object и ключевым словом companion
    }
}