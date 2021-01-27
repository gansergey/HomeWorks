package gan.course2.lesson1;

public class Human implements Action{
    private int lengthMax;
    private int heightMax;
    private String name;

    public Human(int length, int height, String name){
        this.lengthMax = length;
        this.heightMax = height;
        this.name = name;
    }

    public int getLengthMax(){
        return lengthMax;
    }

    public int getHeightMax(){
        return heightMax;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void run() {
        System.out.println("Human running");
    }
    @Override
    public void jump() {
        System.out.println("Human jumped");
    }
}
