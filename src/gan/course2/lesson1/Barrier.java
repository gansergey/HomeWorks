package gan.course2.lesson1;

public interface Barrier {
    boolean running(int lengthMax);
    boolean jumping(int heightMax);
    String getName();
}
