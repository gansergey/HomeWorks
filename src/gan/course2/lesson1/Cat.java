package gan.course2.lesson1;

public class Cat implements Action{

    private int lengthMax;
    private int heightMax;
    private String name;

    public Cat(int lengthMax, int heightMax, String name){
        this.lengthMax = lengthMax;
        this.heightMax = heightMax;
        this.name = name;
    }

    public int getLengthMax() {
        return lengthMax;
    }

    public int getHeightMax() {
        return heightMax;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void run() {
        System.out.println("Cat running");
    }

    @Override
    public void jump() {
        System.out.println("Cat jumped");
    }
}
