package Kingdom

data class Peasant(val occupation: Occupation) {    //2.1Создали класс у которого будет поле с его занятостью(worker, builder, farmer)
}

enum class Occupation { //2.2 для этого используем enum
    WORKER,
    BILDER,
    FARMER
}