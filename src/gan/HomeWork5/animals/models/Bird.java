package gan.HomeWork5.animals.models;

import gan.HomeWork5.animals.Animals;

public class Bird extends Animals {
    public Bird(String name, int limitRun, int limitSwim, float limitJump){
        super(name, limitRun, limitSwim, limitJump);
    }

    @Override
    public void swim(int length) {
        System.out.println("Птицы не умеют плавать");
    }
    //    @Override
//    public void run(int length){
//        if (length <= 5){
//            super.run(length);
//        }else{
//            System.out.println("Птицы не могут пробежать больше 5 метров");
//        }
//    }
//
//    @Override
//    public void jump(float height) {
//        if (height < 0.2){
//            super.jump(height);
//        }else{
//            System.out.println("Птицы не могут прыгать выше 0,2 метров");
//        }
//    }
//
//    @Override
//    public void swim(int length) {
//        System.out.println("Птицы не умеют плававать");
//    }
}
