package Unit_5

//Это, по сути, вариация run, ведет себя она точно таким же образом, но имеет другой синтаксис:
fun main() {
    val list = with(mutableListOf(1, 3, 2, 4)){
        size == 4
    }
    println(list)
}