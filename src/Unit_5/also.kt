package Unit_5

//also - эта функция ведет себя подобно let, но возвращает не результат лямбды, а receiver
//also удобен тогда, когда мы хотим изменить наш receiver, или как-то его использовать.
fun main() {
    mutableListOf(1, 3, 2, 4)
        .also{
            it.sort()//сортируем
        }.also{
            println(it) //[1,2,3,4]
        }
}