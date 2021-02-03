package gan.homeworks.Collection;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        //1. Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся).
        String[] arr = {"Один","Два","Два","Два","Три","Четыре","Пять","Шесть","Семь","Восемь","Девять","Десять"};

            //1.1 Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        Set<String> set = new LinkedHashSet<>(Arrays.asList(arr));
        System.out.println(set);

            //1.2 Посчитать, сколько раз встречается каждое слово. 2 Варианта, делают одно и тоже.
            //Вариант 1
        for (String s : set) {
            System.out.println("Вариант 1: " + s + " - " + Collections.frequency(Arrays.asList(arr), s));
        }
            //Вариант 2
        for (String s : set){
            int countRepeat = 0;
            for (String s1 : arr){
                if (s.equals(s1)){
                    countRepeat ++;
                }
            }
            System.out.println("Вариант 2: " + s + " - " + countRepeat);
        }

    }
}
