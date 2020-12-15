package gan.homeworks;

public class HomeWork1 {

    public static void main(String[] args){

        /*В первом и втором задании не написано вывести ответ в консоль, но так удобнее смотреть.
        Переменной соотвественно тоже можно присвоить результат*/
        //1) float rez = calculateMath1(5,4,3,10);
        //2) boolean rez2 = calculateMath2(5,10);

        //1.
        System.out.println(calculateMath1(5,4,3,10));
        //2.
        System.out.println(calculateMath2(5,10));
        //3.
        calculateMath3(-2);
        //4.
        checkLeapYear(2020);
    }

    //Домашнее задание Урок 1. Java. Введение

    /* 1) Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий
    результат с плавающей точкой, где a, b, c, d – целочисленные входные параметры этого метода;*/
    public static float calculateMath1(int a, int b, int c, int d){
        return ((float)a * ((float)b + ((float)c / (float)d)));
    }

    /* 2) Написать метод, принимающий на вход два целых числа, и проверяющий что их сумма лежит
    в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;*/
    public static boolean calculateMath2(int a, int b){
        boolean rez;
        int sumNumbers = a + b;

        if (sumNumbers >= 10 & sumNumbers <= 20){
            rez = true;
        }else{
            rez = false;
        }
        return rez;
    }

    /* 3)Написать метод, которому в качестве параметра передается целое число, метод должен проверить
    положительное ли число передали, или отрицательное. Замечание: ноль считаем положительным числом.
    Результат работы метода вывести в консоль*/
    public static void calculateMath3(int x){
        if (x >= 0){
            System.out.println("Число (" + x + ") положительное");
        }else{
            System.out.println("Число (" + x + ") отрицательное");
        }
    }

    /* 4)Написать метод, который определяет является ли год високосным.
    Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    Для проверки работы вывести результаты работы метода в консоль*/

    public static void checkLeapYear(int year){
        if (year % 400 == 0){
            System.out.println("Год: " + year + " високосный");
        }else if (year % 4 == 0 & year % 100 != 0 ){
            System.out.println("Год: " + year + " високосный");
        }else{
            System.out.println("Год: " + year + " невисокосный");
        }
    }

}
