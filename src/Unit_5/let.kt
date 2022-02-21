package Unit_5

fun main() {
    //let - передает receiver в лямбду ключевым словом it:
    val list = mutableListOf(1, 3, 2, 4).first().let{
        it + it*100
    }

    println(list)   //101

    //Также let можно совместить с другими синтаксическими конструкциями, пример с Элвисом для обработки null:
    fun sayHey(name:String?):String {
        return name?.let{
            "Hey, $it"
        }?:"Hey, stranger"
    }

    //стандартная конструкция с if-else
    fun sayHey1(name:String?):String {
        return if(name!=null) {
            "Hey, $name"
        } else {
            "Hey, stranger"
        }
    }

    //let передает receiver в лямбду, let передает как результат последнюю строку в лямбде, let не изменяят receiver а лишь его применяет, поэтому изменение receiver внутри лямбды не поменяет сам receiver
}