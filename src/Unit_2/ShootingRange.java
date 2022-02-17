package Unit_2;

public class ShootingRange {
    public static void main(String[] args) {
        /////Реализация интерфейса без анонимности///////
//        Shooter shooter = new Shooter(new Pistol());//3.вкладываем в класс Shooter принимаемые значения из класса Pistol
//        shooter.shooterGun.shoot();//4. На объекте shooter вызываем объект интерфейса shooterGun и вызываем метод shoot() переопределенный в классе Pistol
//        shooter.shooterGun.reload();

        /////Реализация интерфейса с анонимным классом//////
        Shooter shooterBazuka = new Shooter(new Gun(){
            @Override
            public void shoot(){
                System.out.println("KABOOM");
            }

            @Override
            public void reload(){
                System.out.println("wank-wank");
            }
        });

        shooterBazuka.shooterGun.shoot();
        shooterBazuka.shooterGun.reload();
    }
}

interface Gun {
    void shoot();
    void reload();
}

class Shooter {
    Gun shooterGun; //1.callback - в классе мы создали объект интерфейса
    public Shooter(Gun gun){//2. и инициализировали его в конструкторе класса
        shooterGun = gun;
    }
}

//class Pistol implements Gun {
//    @Override
//    public void shoot() {
//        System.out.println("puff-puff");
//    }
//    @Override
//    public void reload() {
//        System.out.println("click-clack");
//    }
//}

/**
 * чем отличаются анонимные классы созданные на основе интерфейса и на основе класса в Java?
 * Анонимный класс согласно JLS 15.9.5 представляют собой выражение, в котором объявление нового класса и его инициализация совмещены:
 *
 * При объявлении класса будет создан новый класс, производный от указанного класса при использовании в качестве базы другого класса,
 * или реализующий интерфейс при использовании в качестве базы интерфейса.
 * При инициализации будет создан новый объект и на него будет возвращения ссылка: анонимный класс является конкретным.
 * Таким образом, единственное отличие в анонимных классах, созданных на основе интерфейса и класса, заключается в количестве абстракных методов, которые необходимо реализовать.
 *
 * Инициализации анонимного класса на основе интерфейса потребует реализации каждого метода, в то время как при инициализации анонимного класса на основе абстрактного/конкретного класса позволит
 * изменить поведение за счет перегрузки методов и потребует реализации абстракных методов.
 */