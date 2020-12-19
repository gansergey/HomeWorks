package gan.homeworks;

import java.util.Arrays;

public class HomeWork2 {

    public static void main(String[] args){
        //1.
        replaceNumbersInArr();
        //2.
        addNumbersInArr();
        //3.
        int[] arrNumbers  = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        mathArr(arrNumbers);
        //4.
        searchMinMax();
        //5.
        diagonalArr();
        //6.
        int[] arrNumbersInt  = {1, 1, 1, 2, 1};
        //int[] arrNumbersInt  = {2, 1, 1, 2, 1}; //для теста False из ДЗ
        System.out.println("\nЗадание 6: Сумма левой и правой части равны? " + compareArr(arrNumbersInt));
        //7-8.
        int[] arrNumbers2 = {1,2,3,4,5};
        mathArr2(arrNumbers2,2);
    }

    /*1 Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    Написать (gan) метод, заменяющий в  принятом массиве 0 на 1, 1 на 0;*/
    public static void replaceNumbersInArr(){
        byte[] arrNumbers  = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("\nЗадание 1: Первоначальный массив:\t" + Arrays.toString(arrNumbers));
        for (int i = 0; i < arrNumbers.length; i++){
            arrNumbers[i] =  arrNumbers[i] == 0 ? (arrNumbers[i] = 1) : (arrNumbers[i] = 0);
        }
        System.out.println("Задание 1: Инверсированный массив:\t" + Arrays.toString(arrNumbers));
    }

    /*2 Задать пустой целочисленный массив (gan) размером 8. Написать метод, который c помощью цикла заполнит
    его значениями 1 4 7 10 13 16 19 22;*/
    public static void addNumbersInArr(){
        int[] arrNumbers2 = new int[8];
        for (int i = 0; i < arrNumbers2.length; i++){
            arrNumbers2[i] = (i == 0) ? (arrNumbers2[i] = 1) : (arrNumbers2[i - 1] + 3);
        }
        System.out.println("\nЗадание 2: Заполненный в цикле массив:\t" + Arrays.toString(arrNumbers2));
    }

    /* 3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], написать метод, принимающий на вход массив (gan) и
    умножающий числа меньше 6 на 2;*/
    public static void mathArr(int[] arr){
        System.out.println("\nЗадание 3: Первоначальный массив:\t" + Arrays.toString(arr));
        for(int i = 0; i < arr.length; i++){
            if (arr[i] < 6) arr[i] *= 2;
        }
        System.out.println("Задание 3: Преобразованый массив:\t" + Arrays.toString(arr));
    }

    /* 4 Задать одномерный массив (gun). Написать методы поиска в нём минимального и максимального элемента;*/
    public static void searchMinMax(){
        float[] arrayNumbers = {500.5f, 4, 8.4f, -10, 15.58f, 9000, 0, 45, 33, 457, 154};
        float max = arrayNumbers[0];
        float min = max;
        for (int i = 1; i < arrayNumbers.length; i++){/* от одного потому, что нет смысла проверять нулевой т.к. min
            и max уже присвоен нулевой элемент. можно через из if но оставил так.*/
            if (arrayNumbers[i] > max) max = arrayNumbers[i];
            if (arrayNumbers[i] < min) min = arrayNumbers[i];
        }
        System.out.println("\nЗадание 4: Максимальное число = " + max + "\tМинимальное значение = " + min);
    }

    /* 5 * Создать квадратный целочисленный массив gun (количество строк и столбцов одинаковое), заполнить его
    диагональные элементы единицами, используя цикл(ы);*/
    public static void diagonalArr(){
        int[][] arr = new int[7][7];

        int lengthArr = arr.length - 1;
        for (int i = 0; i <= lengthArr; i++){
            arr[i][i] = 1;
            arr[lengthArr - i][i] = 1;
        }
        System.out.println("\nЗадание 5: Вывод диагонально заполненного массива");
        printArr(arr);
    }

    /*6 ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true
    если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры:
        checkBalance([1, 1, 1, || 2, 1]) → true,
        checkBalance ([2, 1, 1, 2, 1]) → false,
        checkBalance ([10, || 1, 2, 3, 4]) → true.
        Абстрактная граница показана символами ||, эти символы в массив не входят.gun*/
    public static boolean compareArr(int[] arr){
        int sumLeft = 0;
        int sumRight = 0;
        boolean check = false;
        for(int i = 0; i < arr.length; i++){
            sumLeft += arr[i];
            for(int j = i + 1;j < arr.length; j++){
                sumRight += arr[j];
            }
            if (sumLeft == sumRight) {
                check = true;
                break;
            }
            sumRight = 0;
        }
        return check;
    }

    /*8 *** Написать метод, которому на вход подаётся одномерный массив и число n (может быть положительным,
    или отрицательным), при этом метод должен циклически сместить все элементы массива на n позиций.gun
    [1,2,3,4,5], -2 => [3,4,5,1,2]
    [1,2,3,4,5], 2 => [4,5,1,2,3]*/
    public static void mathArr2(int[] arr, int n){
        System.out.println("\nЗадание 8: (без использования дополнительного массива): Первоначальный массив\t" + Arrays.toString(arr));
        int lenArr = arr.length;
        if (n < 0){
            n *= -1;
            for (int i = 0;i < n; i++){
                int onceNumber = arr[0];
                for (int j = 0;j < lenArr;j++){
                    if (j + 1 < lenArr){
                        arr[j] = arr[j + 1];
                    }else{
                        arr[j] = onceNumber;
                    }
                }
            }
        }else{
            for (int i = 0; i < n; i++) {
                int lastNumber = arr[lenArr - 1];
                for (int j = lenArr; j > 0; j--) {
                    if (j - 1 > 0) {
                        arr[j - 1] = arr[j - 2];
                    }else{
                        arr[j - 1] = lastNumber;
                    }
                }
            }
        }
        System.out.println("Задание 8: (без использования дополнительного массива): Массив со смещением\t\t" + Arrays.toString(arr));
    }

    //Вспомогательный метод для вывода двумерного массива в консоль
    public static void printArr(int[][] arr){

        for(int i = 0;i < arr.length; i++){
            for(int j = 0;j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println("");
        }

    }

}
