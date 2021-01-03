package gan.HomeWork5.animals.models;

import gan.HomeWork5.animals.Animals;

public class Horse extends Animals {
    public Horse(String name, int limitRun, int limitSwim, float limitJump){
        super(name, limitRun, limitSwim, limitJump);
    }

//    @Override
//    public void run(int length) {
//        if (length <= 1500){
//           super.run(length);
//        }else{
//            System.out.println("Лошади не могут пробежать больше 1500 метров");
//        }
//    }
//
//    @Override
//    public void jump(float height) {
//        if (height < 3){
//           super.jump(height);
//        }else{
//           System.out.println("Лошади не могут прыгать выше 0,3 метров");
//        }
//    }
//
//    @Override
//    public void swim(int length) {
//        if (length < 10){
//            super.jump(length);
//        }else{
//            System.out.println("Лошадь не может плыть дальше 100 метров");
//        }
//    }
}
