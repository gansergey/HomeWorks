package gan.course2.lesson1;

public class Main {

    public static void main(String[] args) {

        Action[] actions = {
                new Cat(90,10,"Barsik"),
                new Human(150,15, "Vasya"),
                new Robot(800,150,"Atlas, Boston Dynamics")
        };

        Barrier[] barriers = {
                new Treadmill(100, "Беговая дорожка"),
                new Wall(20, "Стена")
        };

        for (Action a : actions) {
            boolean checkAction = true;
            for (Barrier b : barriers) {
                System.out.println(a.getName() + " пробует преодолеть препядствие " + b.getName());

                if (b.jumping(a.getHeightMax()) || b.running(a.getLengthMax())){
                    System.out.println("Препядствие " + b.getName() + " - Пройдено");
                }else{
                    checkAction = false;
                    System.out.println("Препядствие " + b.getName() + " - Не пройдено");
                }
            }

            if (checkAction){
                System.out.println("Препядствия пройдены");
            }else {
                System.out.println("Препядствия не пройдены");
            }
           System.out.println();
        }
    }
}
