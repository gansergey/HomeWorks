package gan.homeworks.HomeWork5.animals;

public class Animals {

    protected String name;
    protected int limitRun;
    protected int limitSwim;
    protected float limitJump;

    public Animals(String name, int limitRun, int limitSwim, float limitJump){
        this.name = name;
        this.limitRun = limitRun;
        this.limitSwim = limitSwim;
        this.limitJump = limitJump;
    }

    public void run(int length){
        if (length <= limitRun){
            System.out.println(name + " пробежал " + length + " метров");
        }else{
            System.out.println(name + " не может пробежать больше " + limitRun + " метров");
        }
    }

    public void swim(int length){
        if (length <= limitSwim){
            System.out.println(name + " проплыл " + length + " метров");
        }else{
            System.out.println(name + " не может пробылыть больше " + limitSwim + " метров");
        }
    }

    public void jump(float height){
        if (height <= limitJump){
            System.out.println(name + " прыгнул на " + height + " метров");
        }else{
            System.out.println(name + " не может прыгнуть выше " + limitJump + " метров");
        }
    }
}

