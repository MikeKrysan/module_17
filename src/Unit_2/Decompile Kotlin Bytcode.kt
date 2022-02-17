package Unit_2

/*
Decompile Kotlin Bytecode - нужен для того, чтобы посмотреть как код написанный в Kotlin, будет выглядеть в представлении Java
Рассмотрим это на примере Companian Object и заодно посмотрим, как достигается статичность
 */

fun main() {
    println(Amigos.Fernando.tequila)
}

//class Amigos{
//    companion object {
//        val tequila = 0.5
//    }
//}

/*
Decompile Kotlin Bytecode:
в классе Amigo: появился private static final double переменная tequila и появился экземпляр класса Companion

в класссе Companion есть геттер getTequila()

в методе main():  у статичного класса Amigo(класс верхнего уровня) вызывается статический класс Companion(потому что  внутренний класс в Amigo)
 и уже  у него вызывается геттер getTequila(), который нам возвращает статическое значение которое есть в классе Amigo
 */

//class Amigos{
//    companion object {
//        @JvmField   //такой подход хорошо в том случае, если нужно будет работать с библиотеками Java, в остальных случаях достаточно указывать переменные в Companian object и необязательно помечать их @JvmField
//        val tequila = 0.5
//    }
//}

/*
в классе Amigo:
public static final double tequila
создается объект класса Companion

в классе Companion: уже нет геттера
в методе main: обращение идет напрямую
 */

//class Amigos{
//    object Fernando{
//        val tequila = 0.5
//    }
//}
/*
в классе Amigo нет переменных, ни экземпляра внутреннего класса
Все происходит в классе Fernando: приватная статичная переменная tequila, статичный экземпляр этого же класса и геттер getTequila().
Соответсвенно, доступ к переменной происходить следующим образом: статичный класс верхнего уровня Amigo обращается к статичному классу Fernando, где есть INSTANCE самого класса и геттер, через которую мы получаем поле
Происходит похоже как и  Companian Object
 */

class Amigos{
    object Fernando{
        @JvmField
        val tequila = 0.5
    }
}

/*
класс Amigo: никаких переменных нет
класс Fernando: переменная tequila стала публичной, также создается внутреннея переменная класса Fernando. обращение в main к tequila стало короче.,
В общем похоже, как и с Companian Object
 */