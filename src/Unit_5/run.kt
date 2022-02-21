package Unit_5

//run похож по действию на appply, только в отличие от apply, run не возвращт receiver, он возвращает результат лямбды, то-есть то, что было указано  в последней строке
fun main() {
    val list = mutableListOf(1,3, 2, 4 ).run{
        size == 3
    }
    println(list)   //true
}