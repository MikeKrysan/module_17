package Unit_5

fun main() {
    fun String.addDashes() = "-$this-"  //строка, к которой мы применим extension - будет receiver ( получатель)

//apply - функция может быть рассмотрена как функция для настройки конфигурации объекта
    //здесь мы не используем apply
    val list = mutableListOf(1, 3, 2, 4)
    list.add(0)
    list.removeAt(4)
    list.sort()
    list.clear()

    //a здедсь используем:
    val list1 = mutableListOf(1, 3, 2, 4).apply{
        add(0)
        removeAt(0)
        sort()
        clear()
    }
    //Код получается лаконичнее и читабельнее. Мы перечисляем все, что хотим сделать с объектом, в фигурных скобках, не указывая явно на наш объект
    //applay не передает receiver в лямбду, а передает текущий receiver. Изменения receiver внутри лямбды меняет сам receiver
}