package gan.course2.lesson1;

public class Wall implements Barrier {

    int height;
    String name;
    private static final String nameBarrier = "Wall";

    public Wall(int height, String name){
        this.height = height;
        this.name = name;
    }

    @Override
    public boolean running(int lengthMax) {
        return false;
    }

    @Override
    public boolean jumping(int heightMax) {
        return (height <= heightMax);
    }

    @Override
    public String getName() {
        return name;
    }
}
