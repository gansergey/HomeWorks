package gan.homeworks.HomeWork5.animals.models;

import gan.homeworks.HomeWork5.animals.Animals;

public class Dog extends Animals {
    public Dog(String name, int limitRun, int limitSwim, float limitJump){
        super(name, limitRun, limitSwim, limitJump);
    }

//    @Override
//    public void run(int length){
//        if (length <= 500) {
//            super.run(length);
//        }else{
//            System.out.println("Собаки не может пробежать больше 500 метров");
//        }
//    }
//
//    @Override
//    public void jump(float height) {
//        if (height < 0.5){
//            super.jump(height);
//        }else{
//            System.out.println("Собака не может прыгать выше 0,5 метров");
//        }
//    }
//
//    @Override
//    public void swim(int length) {
//        if (length < 10){
//            super.jump(length);
//        }else{
//            System.out.println("Собака не может плыть дальше 10 метров");
//        }
//    }
}
