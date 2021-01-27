package gan.course2.lesson1;

public class Treadmill implements Barrier {
    int length;
    String name;

    public Treadmill(int length, String name){
        this.length = length;
        this.name = name;
    }

    @Override public boolean running(int lengthMax) {
        return lengthMax >= length;
    }

    @Override
    public boolean jumping(int heightMax) {
        return false;
    }

    @Override
    public String getName() {
        return name;
    }
}
