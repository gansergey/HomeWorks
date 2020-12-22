package gan.HomeWork4;

public class Main {
    private static Personal[] personals;

    public static void main(String[] args) {

        //1 Создать класс "Сотрудник" с полями: ФИО, должность, телефон, зарплата, возраст;
        //Создал

        //2 Конструктор класса должен заполнять эти поля при создании объекта;
        Personal personal = new Personal("Иванов Иван Иванович", "Менеджер", "8-999-222-99-99", 80000, 25);

        //3 Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
        //Реализовал

        //4 Вывести при помощи методов из пункта 3 ФИО и должность.
        System.out.println("Имя сотрудника: " + personal.getFio() + "\nДолжность сотрудника: " + personal.getPost() + "\n");


        //5 Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
        personals = new Personal[5];
        personals[0] = new Personal("Иванов Иван Иванович", "Менеджер", "8-999-222-99-99", 90000, 30);
        personals[1] = new Personal("Степанов Сергей Владимировач","Программист", "8-921-888-88-88", 200000, 30);
        personals[2] = new Personal("Сидорова Ирина Александровна", "Товаровед", "8-901-111-11-11", 25000, 48);
        personals[3] = new Personal("Петров Иван Фёдорович", "Системный администратор", "8-861-222-22-22", 29000, 34);
        personals[4] = new Personal("Срарцев Фёдор Иванович", "Инженер", "8-264-444-44-44", 30000, 55);

        for (int i = 1; i < personals.length; i++){
            if (personals[i].getAge() > 40)
                System.out.println("Сотрудник старше 40 лет: " + personals[i].getFio());
        }

        //6* Создать метод, повышающий зарплату всем сотрудникам старше 35 лет на 10000;
        upSalary();
        getInfo();

        //7** При создании экземпляра класса Сотрудник присваивать ему уникальный порядковый номер.
        //Написал в классе Personal с помощью переменых index и number и метода setIndex
    }

    public static void upSalary(){
        for (int i = 0; i < personals.length; i++){
            if (personals[i].getAge() > 35)
                personals[i].setSalary(personals[i].getSalary()+ 10000);
        }
    }

    public static void  getInfo(){
        for(int i = 0; i < personals.length;i++){
            personals[i].getInfo();
        }
    }


}