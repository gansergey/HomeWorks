package gan.homeworks.HomeWork5.animals.models;

import gan.homeworks.HomeWork5.animals.Animals;

public class Cat extends Animals {
    public Cat(String name, int limitRun, int limitSwim, float limitJump){
        super(name, limitRun, limitSwim, limitJump);
    }

    @Override
    public void swim(int length) {
        System.out.println("Коты не умеют плавать");
    }
//    @Override
//    public void run(int length) {
//         if (length <= 200){
//             super.run(length);
//         }else{
//             System.out.println("Коты не могут пробежать больше 200 метров");
//         }
//    }
//
//    @Override
//    public void jump(float height) {
//        if (height < 2){
//            super.jump(height);
//        }else{
//            System.out.println("Коты не могут прыгать больше 2 метров");
//        }
//    }
//
//    @Override
//    public void swim(int length) {
//        System.out.println("Коты не умеют плававать");
//    }
}
