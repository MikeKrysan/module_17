package Unit_1

fun main() {

}

class MyClass3() {
    private var _name: String = "Bobik"
    private var name:String
        get() = _name
        set(value) {
            _name = value
        }

}