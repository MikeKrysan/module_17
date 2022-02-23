package Kingdom

data class Peasant(val occupation: Occupation) {    //2.1Создали класс у которого будет поле с его занятостью(worker, builder, farmer)
}

enum class Occupation { //2.2 для этого используем enum
    WORKER { override fun getTaxAmount() = 1},
    BILDER { override fun getTaxAmount() = 2},
    FARMER { override fun getTaxAmount() = 3};

    abstract fun getTaxAmount(): Int


}