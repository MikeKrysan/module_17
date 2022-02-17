package Unit_3

//Crossline- если в inline функции делать return, то вы также делает return из функции, в которой находится inline функция
fun main(){
    println("Start")

    multiplayByTwo(5) {  //Это inline функция
        println(it)
        return  //выход из функции
    }

    //prinln("End")   //Этот код не выполнится, так как мы выйдем из функции main
}

inline fun multiplayByTwo(i: Int, /*crossinline*/  lambda: (result: Int) -> Unit) : Int {    //когда мы пометим нашу лямбду в которой происходит возврат ключевым словом crosinline, IDE будет контролировать, чтобы мы не делали return
    val result = i*2
    lambda.invoke(result)
    return  result
}