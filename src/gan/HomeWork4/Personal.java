package gan.HomeWork4;

public class Personal {

    private final String fio;
    private final String post;
    private final String phone;
    private int salary;
    private final int age;
    private static int index;
    private final int number;

    Personal(String fio, String post, String phone, int salary, int age){
        number = setIndex();
        this.fio = fio;
        this.post = post;
        this.phone = phone;
        this.salary= salary;
        this.age = age;
    }

    public void getInfo() {
        System.out.println("\t|" + getNumber() + "\t|" + getFio() + "|\t|" + getPost() + "|\t|" + getPhone() +
                "|\t|" + getSalary() + " руб." + "|\t|" + getAge() + " лет");
    }

    public String getFio() {
        return fio;
    }

    public String getPost() {
        return post;
    }

    public String getPhone() {
        return phone;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    private int setIndex() {
        return index += 1;
    }

    public int getNumber() {
        return number;
    }
}